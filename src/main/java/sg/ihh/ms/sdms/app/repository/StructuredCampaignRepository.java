package sg.ihh.ms.sdms.app.repository;


import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.StructuredCampaignDetails;
import sg.ihh.ms.sdms.app.model.StructuredPageBasicDetail;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.List;

@Repository
public class StructuredCampaignRepository extends BaseRepository {
    public StructuredCampaignRepository() {
        log = getLogger(this.getClass());
    }

    // START - Structured Campaign Basic Details
    public StructuredCampaignDetails getStructuredCampaignDetails(Version version, List<String> languageList, String structuredCampaignUrl, String hospitalCode){
        final String methodName = "StructuredCampaignDetails";
        start(methodName);

        String sql = "SELECT scs.uid, scs.language_code, scs.campaign_title, scs.item_url, scs.main_image, scs.main_image_alt_text, scsm.overview, scsm.benefits_list, scs.summary, scsm.social_summary, scsm.meta_title, scsm.meta_description, scs.publish_flag, scs.created_dt, scs.modified_dt FROM structured_campaign_sd scs " +
                "LEFT JOIN structured_campaign_sd_metadata scsm ON scs.uid  = scsm.structured_campaign_sd_uid " +
                "LEFT JOIN structured_campaign_sd_hospital scsh ON scs.uid  = scsh.structured_campaign_sd_uid " +
                "LEFT JOIN hospital hm ON hm.uid = scsm.hospital_uid " +
                "LEFT JOIN hospital hh ON hh.uid = scsh.hospital_uid " +
                "WHERE scs.language_code IN(<languageList>) AND scs.item_url = :item_url AND hm.hospital = :hospital AND hh.hospital = :hospital " +
                "AND scs.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        StructuredCampaignDetails structuredCampaignDetails = new StructuredCampaignDetails();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("item_url", structuredCampaignUrl).bind("hospital", hospitalCode);
            structuredCampaignDetails = query.mapToBean(StructuredCampaignDetails.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);

        return structuredCampaignDetails;
    }
}
