package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.*;

import javax.sound.sampled.Port;
import java.util.HashMap;
import java.util.List;

@Repository
public class MedicalProfessionalRepository extends BaseRepository {

    public MedicalProfessionalRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "medical_professional");
        tableMap.put(Version.PUBLISHED.getKey(), "medical_professional_ro");
    }

    public List<MedicalProfessionalBasic> list(Version version, List<String> languageList) {
        final String methodName = "list";
        start(methodName);

        String sql = "SELECT mp.*, mpt.profession AS type FROM medical_professional mp " +
                " LEFT JOIN medical_professional_type mpt ON mp.medical_professional_type_uid = mpt.uid " +
                " LEFT JOIN media_coverage mc ON mp.uid = mc.related_specialist_uid " +
                " WHERE mp.language_code IN(<languageList>)";

        sql = getTableVersion(version, tableMap, sql);

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
                " GROUP BY mp.uid, mp.language_code";

        sql = getTableVersion(version, tableMap, sql);

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

    public List<MedicalProfessionalDetail> getDetails(Version version, List<String> languageList, String medicalProfessionalItemUrl, String hospitalCode) {
        final String methodName = "getDetails";
        start(methodName);

        String sql = "SELECT mp.*, l.language, ip.insurance, g.gender, s.specialty, mpmd.meta_title, mpmd.meta_description, COUNT(mc.title) > 0 AS media_coverage FROM medical_professional mp " +
                        " LEFT JOIN medical_professional_specialty mps ON mp.uid = mps.medical_professional_uid " +
                        " LEFT JOIN specialty s ON s.uid = mps.specialty_uid " +
                        " LEFT JOIN medical_professional_language mpl ON mp.uid = mpl.medical_professional_uid " +
                        " LEFT JOIN language l ON l.uid = mpl.language_uid " +
                        " LEFT JOIN medical_professional_insurance mpi ON mp.uid = mpi.medical_professional_uid " +
                        " LEFT JOIN insurance_panel ip ON ip.uid = mpi.insurance_uid " +
                        " LEFT JOIN gender g ON g.uid = mp.gender_uid " +
                        " LEFT JOIN medical_professional_metadata mpmd ON mp.uid = mpmd.medical_professional_uid " +
                        " LEFT JOIN medical_professional_metadata_hospital mpmdh ON mpmdh.medical_professional_metadata_uid = mpmd.uid " +
                        " LEFT JOIN hospital h ON mpmdh.hospital_uid = h.uid " +
                        " LEFT JOIN media_coverage mc ON mp.uid = mc.related_specialist_uid " +
                        " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url " +
                        " GROUP BY mp.uid, mp.language_code, l.language, ip.insurance, g.gender, s.specialty, mpmd.meta_title, mpmd.meta_description";

        sql = getTableVersion(version, tableMap, sql);

        List<MedicalProfessionalDetail> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapToBean(MedicalProfessionalDetail.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Portfolio> getPortfolio(Version version, List<String> languageList, String medicalProfessionalItemUrl, String country) {
        final String methodName = "getPortfolio";
        start(methodName);

        String sql = "SELECT mp.*, at.treatment, mpa.achievement, mpe.experiences, mpaw.award FROM medical_professional mp " +
                " LEFT JOIN medical_professional_assoc_treatment mpat ON mp.uid = mpat.medical_professional_uid " +
                " LEFT JOIN associated_treatment at ON at.uid = mpat.associated_treatment_uid " +
                " LEFT JOIN medical_professional_achievement mpa ON mp.uid = mpa.medical_professional_uid " +
                " LEFT JOIN medical_professional_achievement_country mpac ON mpa.uid = mpac.medical_professional_achievement_uid " +
                " LEFT JOIN country ac ON ac.uid = mpac.country_uid " +
                " LEFT JOIN medical_professional_experience mpe ON mp.uid = mpe.medical_professional_uid " +
                " LEFT JOIN medical_professional_experience_country mpec ON mpe.uid = mpec.medical_professional_experience_uid " +
                " LEFT JOIN country ec ON ec.uid = mpec.country_uid " +
                " LEFT JOIN medical_professional_award mpaw ON mp.uid = mpaw.medical_professional_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url";

        sql = getTableVersion(version, tableMap, sql);

        List<Portfolio> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl).bind("country", country);
            result = query.mapToBean(Portfolio.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<MediaCoverage> getMediaCoverage(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getMediaCoverage";
        start(methodName);

        String sql = "SELECT mc.* FROM media_coverage mc " +
                " LEFT JOIN medical_professional mp ON mp.uid = mc.related_specialist_uid " +
                " WHERE mp.language_code IN(<languageList>) AND mp.item_url = :item_url";

        sql = getTableVersion(version, tableMap, sql);

        List<MediaCoverage> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapToBean(MediaCoverage.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Testimonial> getTestimonials(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getTestimonials";
        start(methodName);

        String sql = "SELECT mpt.* FROM medical_professional_testimonial mpt " +
                " LEFT JOIN medical_professional mp ON mp.uid = mpt.medical_professional_uid " +
                " LEFT JOIN medical_professional_testimonial_country mptc ON mpt.uid = mptc.medical_professional_testimonial_uid " +
                " LEFT JOIN country c ON mptc.country_uid = c.uid " +
                " WHERE mpt.language_code IN(<languageList>) AND mp.item_url = :item_url";

        sql = getTableVersion(version, tableMap, sql);

        List<Testimonial> result = null;
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", medicalProfessionalItemUrl);
            result = query.mapToBean(Testimonial.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    public List<Clinic> getClinics(Version version, List<String> languageList, String medicalProfessionalItemUrl) {
        final String methodName = "getClinics";
        start(methodName);

        String sql = "SELECT mpc.*, c.clinic_name, c.address, c.phone_numbers, c.fax_numbers FROM medical_professional_clinic mpc " +
                " LEFT JOIN medical_professional mp ON mp.uid = mpc.medical_professional_uid " +
                " LEFT JOIN clinic c ON mpc.clinic_uid = c.uid " +
                " WHERE mpc.language_code IN(<languageList>) AND mp.item_url = :item_url";

        sql = getTableVersion(version, tableMap, sql);

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
