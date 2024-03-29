package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.util.constant.Constant;

import java.util.*;

@Repository
public class MedicalProfessionalRepository extends BaseRepository {

    public MedicalProfessionalRepository() {
        log = getLogger(this.getClass());
    }

    public List<MedicalProfessionalBasic> list(Version version, List<String> languageList) {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT mp.*, mpt.profession AS type FROM medical_professional mp  " +
                "LEFT JOIN medical_professional_type mpt ON mp.medical_professional_type_uid = mpt.uid " +
                "LEFT JOIN media_coverage_related_specialist mcrs ON mp.uid = mcrs.medical_professional_uid AND mp.language_code = mcrs.language_code AND mp.status = mcrs.status " +
                "LEFT JOIN media_coverage mc ON mc.uid = mcrs.media_coverage_uid AND mc.language_code = mcrs.language_code AND mc.status = mcrs.status " +
                " WHERE mp.language_code IN(<languageList>) " +
                " AND mp.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<MedicalProfessionalBasic> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList);
            result = query.mapToBean(MedicalProfessionalBasic.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }


    public String getDisplayName(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getDisplayName";
        start(methodName);

        String sql = "SELECT mp.display_name FROM medical_professional mp " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY mp.uid, mp.language_code";

        sql = getPublishVersion(version, sql);

        String result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            Optional<String> displayName = query.mapTo(String.class).findOne();
            result = displayName.isPresent() ? displayName.get() : "";

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    public List<MedicalProfessionalDetail> getDetails(Version version, List<String> languageList, String medicalProfessionalItemUrl, String hospitalCode) {
        final String methodName = "getDetails";
        start(methodName);

        String sql =    " SELECT mp.*, mpt.profession AS med_pro_type, g.gender, s.specialty, COUNT(mc.title) > 0 AS media_coverage, spt.type as service_provider_type FROM medical_professional mp " +
                        " LEFT JOIN medical_professional_specialty mps ON mp.uid = mps.medical_professional_uid AND mp.language_code = mps.language_code AND mp.status = mps.status " +
                        " LEFT JOIN specialty s ON s.uid = mps.specialty_uid " +
                        " LEFT JOIN service_provider_type spt ON spt.uid = mp.service_provider_uid " +
                        " LEFT JOIN gender g ON g.uid = mp.gender_uid " +
                        " LEFT JOIN media_coverage_related_specialist mcrs  ON mp.uid = mcrs.medical_professional_uid AND mp.language_code = mcrs.language_code AND mp.status = mcrs.status " +
                        " LEFT JOIN media_coverage mc ON mc.uid = mcrs.media_coverage_uid AND mc.language_code = mcrs.language_code AND mc.status = mcrs.status " +
                        " LEFT JOIN medical_professional_type mpt ON mpt.uid = mp.medical_professional_type_uid  " +
                        " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                        " AND mp.publish_flag = {PUBLISHED} " +
                        " GROUP BY mp.uid, mp.language_code, g.gender, s.specialty";

        sql = getPublishVersion(version, sql);

        List<MedicalProfessionalDetail> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapToBean(MedicalProfessionalDetail.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        // setting additional information from other tables
        for (MedicalProfessionalDetail medicalProfessionalDetail : result) {
            // setting the array of items
            medicalProfessionalDetail.setInsurancePanel(getMedicalProfessionalInsurance(version, languageList, medicalProfessionalItemUrl));
            medicalProfessionalDetail.setLanguageSpoken(getMedicalProfessionalSpokenLanguages(version, languageList, medicalProfessionalItemUrl));
            medicalProfessionalDetail.setAvailableLanguageCode(getAvailableLanguageCode(version, medicalProfessionalItemUrl));
            medicalProfessionalDetail.setAvailableHospital(getAvailableHospital(version, languageList, medicalProfessionalItemUrl));
            // special handling for specialists and allied health professionals (AHP)
            if (medicalProfessionalDetail.getMedProType().equals(Constant.MEDPRO_SPECIALISTS)) {
                medicalProfessionalDetail.setMetaCta("");
                medicalProfessionalDetail.setLaymanTerm(getMedicalProfessionalSpecialistInfo(version, languageList, medicalProfessionalItemUrl));
            } else if (medicalProfessionalDetail.getMedProType().equals(Constant.MEDPRO_ALLIED_HEALTH_PROFESSIONALS)) {
                Map<String, Object> ahpInfo = getMedicalProfessionalAHPInfo(version, languageList, medicalProfessionalItemUrl);
                medicalProfessionalDetail.setMetaCta((String) ahpInfo.get(Constant.SERVICE_PROVIDER_META_CTA));
                medicalProfessionalDetail.setLaymanTerm((String) ahpInfo.get(Constant.SERVICE_PROVIDER_LAYMAN_TERM));
            }
            Map<String, Object> metadata = getMetadata(version, languageList, medicalProfessionalItemUrl, hospitalCode);
            medicalProfessionalDetail.setMetaTitle((String) metadata.get("meta_title"));
            medicalProfessionalDetail.setMetaDescription((String) metadata.get("meta_description"));
        }

        completed(methodName);
        return result;
    }

    public Map<String, Object> getMetadata(Version version, List<String> languageList, String medicalProfessionalItemUrl, String hospitalCode) {
        final String methodName = "getMetadata";
        start(methodName);

        String sql = "SELECT mpmd.meta_title, mpmd.meta_description FROM medical_professional mp " +
                " LEFT JOIN medical_professional_metadata mpmd ON mp.uid = mpmd.medical_professional_uid AND mp.language_code = mpmd.language_code AND mp.status = mpmd.status " +
                " LEFT JOIN hospital h ON mpmd.hospital_uid = h.uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url AND h.hospital = :hospital " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY mp.uid, mp.language_code";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = new HashMap<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl).bind("hospital", hospitalCode);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    public List<String> getMedicalProfessionalSpokenLanguages(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getMedicalProfessionalSpokenLanguages";
        start(methodName);

        String sql = "SELECT l.language FROM medical_professional mp " +
                " LEFT JOIN medical_professional_language mpl ON mp.uid = mpl.medical_professional_uid AND mp.language_code = mpl.language_code AND mp.status = mpl.status  " +
                " LEFT JOIN language l ON l.uid = mpl.language_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY l.language";

        sql = getPublishVersion(version, sql);

        List<String> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<String> getAvailableHospital(Version version, List<String> languageList, String medicalProfessionalItemUrl){
        final String methodName = "getAvailableHospital";
        start(methodName);

        String sql = "SELECT h.hospital FROM medical_professional mp " +
                " LEFT JOIN medical_professional_hospital mph ON mp.uid = mph.medical_professional_uid AND mp.language_code = mph.language_code AND mp.status = mph.status " +
                " LEFT JOIN hospital h ON mph.hospital_uid  = h.uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY h.hospital";

        sql = getPublishVersion(version, sql);

        List<String> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<String> getAvailableLanguageCode(Version version, String medicalProfessionalItemUrl){
        final String methodName = "getAvailableLanguageCode";
        start(methodName);

        String sql = "SELECT mp.language_code FROM medical_professional mp " +
                " WHERE mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<String> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("item_url", medicalProfessionalItemUrl);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    public List<String> getMedicalProfessionalInsurance(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getMedicalProfessionalInsurance";
        start(methodName);

        String sql = "SELECT i.insurance FROM medical_professional mp " +
                " LEFT JOIN medical_professional_insurance mpi ON mp.uid = mpi.medical_professional_uid AND mp.language_code = mpi.language_code AND mp.status = mpi.status " +
                " LEFT JOIN insurance_panel i ON i.uid = mpi.insurance_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY i.insurance";

        sql = getPublishVersion(version, sql);

        List<String> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public String getMedicalProfessionalSpecialistInfo(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getMedicalProfessionalSpecialistInfo";
        start(methodName);

        String sql = "SELECT s.layman_term FROM medical_professional mp " +
                " LEFT JOIN medical_professional_specialty mps ON mp.uid = mps.medical_professional_uid AND mp.language_code = mps.language_code AND mp.status = mps.status " +
                " LEFT JOIN specialization s ON s.specialty_uid = mps.specialty_uid AND s.language_code = mps.language_code AND s.status = mps.status  " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY s.layman_term";

        sql = getPublishVersion(version, sql);

        String result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapTo(String.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public Map<String, Object> getMedicalProfessionalAHPInfo(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getMedicalProfessionalAHPInfo";
        start(methodName);

        String sql = "SELECT spmd.meta_cta_value AS meta_cta, sp.layman_term FROM medical_professional mp " +
                " LEFT JOIN service_provider sp ON sp.type_uid = mp.service_provider_uid AND sp.language_code = mp.language_code AND sp.status = mp.status " +
                " LEFT JOIN service_provider_metadata spmd ON sp.uid = spmd.service_provider_uid AND sp.language_code = spmd.language_code AND sp.status = spmd.status  " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY spmd.meta_cta_value";

        sql = getPublishVersion(version, sql);

        Map<String, Object> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapToMap().one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Portfolio> getPortfolio(Version version, List<String> languageList, String medicalProfessionalItemUrl, String countryOfResidence) {
        final String methodName = "getPortfolio";
        start(methodName);

        String sql = "SELECT mp.*, at.treatment FROM medical_professional mp " +
                " LEFT JOIN medical_professional_assoc_treatment mpat ON mp.uid = mpat.medical_professional_uid AND mp.language_code = mpat.language_code AND mp.status = mpat.status " +
                " LEFT JOIN associated_treatment at ON at.uid = mpat.associated_treatment_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url" +
                " AND mp.publish_flag = {PUBLISHED} ";

                sql = getPublishVersion(version, sql);

        List<Portfolio> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapToBean(Portfolio.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        for (Portfolio portfolio : result) {
            portfolio.setAchievements(getMedicalProfessionalAchievement(version, languageList, medicalProfessionalItemUrl, countryOfResidence));
            portfolio.setExperiences(getMedicalProfessionalExperience(version, languageList, medicalProfessionalItemUrl, countryOfResidence));
            portfolio.setAwards(getMedicalProfessionalAward(version, languageList, medicalProfessionalItemUrl, countryOfResidence));
            // setting the array of items
            portfolio.setAssociatedTreatments(getAssociatedTreatment(version, languageList, medicalProfessionalItemUrl));
        }

        completed(methodName);
        return result;
    }
    public List<String> getAssociatedTreatment(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getAssociatedTreatment";
        start(methodName);

        String sql = "SELECT at.treatment FROM medical_professional mp " +
                " LEFT JOIN medical_professional_assoc_treatment mpat ON mp.uid = mpat.medical_professional_uid AND mp.language_code = mpat.language_code AND mp.status = mpat.status " +
                " LEFT JOIN associated_treatment at ON at.uid = mpat.associated_treatment_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND mp.publish_flag = {PUBLISHED} " +
                " GROUP BY at.treatment";

        sql = getPublishVersion(version, sql);

        List<String> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public String getMedicalProfessionalAchievement(Version version, List<String> languageList, String medicalProfessionalItemUrl, String countryOfResidence) {
        final String methodName = "getMedicalProfessionalAchievement";
        start(methodName);

        String sql = "SELECT mpa.achievement FROM medical_professional mp " +
                " LEFT JOIN medical_professional_achievement mpa ON mp.uid = mpa.medical_professional_uid AND mp.language_code = mpa.language_code AND mp.status = mpa.status " +
                " LEFT JOIN medical_professional_achievement_country mpac ON mpa.uid = mpac.medical_professional_achievement_uid AND mpa.language_code = mpac.language_code AND mpa.status = mpac.status " +
                " LEFT JOIN country_of_residence c ON c.uid = mpac.cor_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url AND c.cor = :countryOfResidence" +
                " AND mp.publish_flag = {PUBLISHED} AND c.language_code = 'EN'";

                sql = getPublishVersion(version, sql);

        String result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl).bind("countryOfResidence", countryOfResidence);
            result = query.mapTo(String.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    public String getMedicalProfessionalExperience(Version version, List<String> languageList, String medicalProfessionalItemUrl, String countryOfResidence) {
        final String methodName = "getMedicalProfessionalExperience";
        start(methodName);

        String sql = "SELECT mpe.experiences FROM medical_professional mp " +
                " LEFT JOIN medical_professional_experience mpe ON mp.uid = mpe.medical_professional_uid AND mp.language_code = mpe.language_code AND mp.status = mpe.status  " +
                " LEFT JOIN medical_professional_experience_country mpec ON mpe.uid = mpec.medical_professional_experience_uid AND mpe.language_code = mpec.language_code AND mpe.status = mpec.status  " +
                " LEFT JOIN country_of_residence c ON c.uid = mpec.cor_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url AND c.cor = :countryOfResidence" +
                " AND mp.publish_flag = {PUBLISHED} ";

                sql = getPublishVersion(version, sql);

        String result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl).bind("countryOfResidence", countryOfResidence);
            result = query.mapTo(String.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    public String getMedicalProfessionalAward(Version version, List<String> languageList, String medicalProfessionalItemUrl, String countryOfResidence) {
        final String methodName = "getMedicalProfessionalAward";
        start(methodName);

        String sql = "SELECT mpa.award FROM medical_professional mp " +
                " LEFT JOIN medical_professional_award mpa ON mp.uid = mpa.medical_professional_uid AND mp.language_code = mpa.language_code AND mp.status = mpa.status " +
                " LEFT JOIN medical_professional_award_country mpac ON mpa.uid = mpac.medical_professional_award_uid AND mpa.language_code = mpac.language_code AND mpa.status = mpac.status " +
                " LEFT JOIN country_of_residence c ON c.uid = mpac.cor_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url AND c.cor = :countryOfResidence" +
                " AND mp.publish_flag = {PUBLISHED} ";

                sql = getPublishVersion(version, sql);

        String result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl).bind("countryOfResidence", countryOfResidence);
            result = query.mapTo(String.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    public List<MediaCoverage> getMediaCoverage(Version version, List<String> languageList, String medicalProfessionalItemUrl, String mediaCoverageLanguage) {
        final String methodName = "getMediaCoverage";
        start(methodName);

        String sql = "SELECT mc.*, l.language FROM media_coverage mc " +
                " LEFT JOIN media_coverage_related_specialist mcrs  ON mc.uid = mcrs.media_coverage_uid AND mc.language_code = mcrs.language_code AND mc.status = mcrs.status " +
                " LEFT JOIN medical_professional mp ON mp.uid = mcrs.medical_professional_uid AND mp.language_code = mcrs.language_code AND mp.status = mcrs.status " +
                " LEFT JOIN language l ON l.uid = mc.language_uid  " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                " AND l.language = :language AND mp.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<MediaCoverage> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl).bind("language", mediaCoverageLanguage);
            result = query.mapToBean(MediaCoverage.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Testimonial> getTestimonials(Version version, List<String> languageList, String medicalProfessionalItemUrl, String country) {
        final String methodName = "getTestimonials";
        start(methodName);

        String sql = "SELECT mpt.*,cpl.cor FROM medical_professional_testimonial mpt " +
                " LEFT JOIN medical_professional mp ON mp.uid = mpt.medical_professional_uid AND mp.language_code = mpt.language_code AND mp.status = mpt.status " +
                " LEFT JOIN medical_professional_testimonial_country mptc ON mpt.uid = mptc.medical_professional_testimonial_uid AND mpt.language_code = mptc.language_code AND mpt.status = mptc.status " +
                " LEFT JOIN country_of_residence c ON mptc.cor_uid = c.uid" +
                " LEFT JOIN country_of_residence cpl ON mpt.patient_location_uid = cpl.uid" +
                " WHERE mpt.language_code IN(<languageList>) AND mp.item_url = :item_url AND c.cor = :country" +
                " AND mp.publish_flag = {PUBLISHED} ";

                sql = getPublishVersion(version, sql);

        List<Testimonial> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl).bind("country", country);
            result = query.mapToBean(Testimonial.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        for (Testimonial testimonial : result) {
            testimonial.setCountries(getTestimonialCountries(testimonial.getUid(), languageList));
            testimonial.setImages(getTestimonialImages(testimonial.getUid(), languageList));
        }

        completed(methodName);
        return result;
    }
    public List<TestimonialImage> getTestimonialImages(String uid, List<String> languageList) {
        final String methodName = "getTestimonialImages";
        start(methodName);

        String sql = " SELECT mpti.image_url, mpti.image_alt_text  FROM medical_professional_testimonial mpt " +
                " LEFT JOIN medical_professional_testimonial_image mpti ON mpt.uid = mpti.medical_professional_testimonial_uid AND mpt.language_code = mpti.language_code AND mpt.status = mpti.status " +
                " WHERE mpt.uid = :uid AND mpt.language_code IN(<languageList>) ";

        List<TestimonialImage> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("uid", uid).bindList("languageList", languageList);
            result = query.mapToBean(TestimonialImage.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
    public List<String> getTestimonialCountries(String uid, List<String> languageList) {
        final String methodName = "getTestimonialCountries";
        start(methodName);

        String sql = "SELECT c.cor FROM medical_professional_testimonial mpt " +
                " LEFT JOIN medical_professional_testimonial_country mptc ON mpt.uid = mptc.medical_professional_testimonial_uid AND mpt.language_code = mptc.language_code AND mpt.status = mptc.status  " +
                " LEFT JOIN country_of_residence c ON mptc.cor_uid = c.uid " +
                " WHERE mpt.uid = :uid AND mpt.language_code IN(<languageList>) ";

         List<String> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("uid", uid).bindList("languageList", languageList);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Clinic> getClinics(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getClinics";
        start(methodName);

        String sql = "SELECT c.uid, mpc.language_code, mpc.is_primary_clinic, mpc.created_dt, mpc.modified_dt, " +
                " mpc.publish_flag, mpc.display_order, mpc.status, mpc.publish_date, c.name, c.address_1, " +
                " c.address_2, c.city, c.state, c.postal_code, c.phone_numbers, c.fax_numbers " +
                " FROM medical_professional_clinic mpc " +
                " LEFT JOIN medical_professional mp ON mp.uid = mpc.medical_professional_uid AND mp.language_code = mpc.language_code AND mp.status = mpc.status " +
                " LEFT JOIN clinic c ON mpc.clinic_uid = c.uid " +
                " WHERE mpc.language_code IN(<languageList>) AND mp.item_url = :item_url" +
                " AND mp.publish_flag = {PUBLISHED} ";

                sql = getPublishVersion(version, sql);

        List<Clinic> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapToBean(Clinic.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
}
