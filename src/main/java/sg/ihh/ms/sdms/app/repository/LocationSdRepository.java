package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.LocationSd;
import sg.ihh.ms.sdms.app.model.LocationSdContact;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.ArrayList;
import java.util.List;


@Repository
public class LocationSdRepository  extends BaseRepository {

    public LocationSdRepository() {
        log = getLogger(this.getClass());
    }

    //START - Get Locations by Item Url
    public  List<LocationSd> getLocationByItemUrl(Version version, List<String> languageList, List<String> itemUrls){
        final String methodName = "getLocationByItemUrl";
        start(methodName);
        List<LocationSd> result = new ArrayList<>();

        for (String itemUrl : itemUrls){
            List<LocationSd> ls = getLocationSd(version, languageList, itemUrl);
            List<LocationSdContact> lsc = getLocationSdContactByItemUrl(version, languageList, itemUrl);
            List<String> hospitalList = checkHospitalList(version, languageList, itemUrl, null, null, null);
            for (LocationSd lsResult : ls){
                lsResult.setContactNumbers(lsc);
                lsResult.setHospitals(hospitalList);
                result.add(lsResult);
            }
        }
        completed(methodName);
        return result;
    }


    public List<LocationSd> getLocationSd(Version version, List<String> languageList, String itemUrls){
        final String methodName = "getLocationByItemUrl";
        start(methodName);
        String sql ="SELECT ls.uid, ls.language_code, ls.location_title,ls.image_url, ls.google_map_url, ls.address1, ls.address2, ls.city , ls.state, ls.postal_code, cor.cor , ls.whatsapp_number, ls.fax, ls.email, ls.display_order, ls.publish_flag, ls.created_dt, ls.modified_dt FROM location_sd ls " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid " +
                "WHERE ls.language_code IN(<languageList>) AND ls.item_url = :itemUrls " +
                "AND ls.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<LocationSd> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrls", itemUrls);
            result = query.mapToBean(LocationSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    private List<LocationSdContact> getLocationSdContactByItemUrl(Version version, List<String> languageList, String itemUrls){
        final String methodName = "getLocationSdContact";
        start(methodName);
        String sql ="SELECT lsc.contact_header, lsc.contact_number, lsc.display_order  FROM location_sd ls " +
                "LEFT JOIN location_sd_contact lsc  ON ls.uid = lsc.location_sd_uid AND ls.status = lsc.status AND ls.language_code = lsc.language_code " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid AND ls.status = cor.status AND ls.language_code = cor.language_code  " +
                "WHERE ls.language_code IN(<languageList>) AND ls.item_url = :itemUrls " +
                "AND ls.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<LocationSdContact> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrls", itemUrls);
            result = query.mapToBean(LocationSdContact.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);

        return result;
    }
    //END - Get Locations by Item Url

    //START - Get Locations by Centre & Service
    public List<LocationSd> getLocationByCentreService(Version version, List<String> languageList, String itemUrlMain,String itemUrlSub, String hospitalCode){
        final String methodName = "getLocationByCentreService";
        start(methodName);
        String sql = "SELECT ls.uid, ls.language_code, ls.location_title,ls.image_url, ls.google_map_url, ls.address1, ls.address2, ls.city , ls.state, ls.postal_code, cor.cor , ls.whatsapp_number, ls.fax, ls.email, csssl.display_order, ls.publish_flag, ls.created_dt, ls.modified_dt FROM centre_service_sub_sd csss " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code  " +
                "LEFT JOIN centre_service_sub_sd_location csssl ON csss.uid = csssl.centre_service_sub_sd_uid AND csss.status = csssl.status AND csss.language_code = csssl.language_code " +
                "LEFT JOIN location_sd ls  ON ls.uid = csssl.location_uid AND ls.status = csssl.status AND ls.language_code = csssl.language_code " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid AND ls.status = cor.status AND ls.language_code = cor.language_code " +
                "LEFT JOIN centre_service_sub_sd_location_hospital cssslh ON csssl.uid  = cssslh.centre_service_sub_sd_location_uid AND cssslh.status = csssl.status AND cssslh.language_code = csssl.language_code " +
                "LEFT JOIN hospital h ON cssslh.hospital_uid  = h.uid " +
                "WHERE ls.language_code IN(<languageList>)AND csms.item_url = :itemUrlMain AND csss.item_url = :itemUrlSub  AND h.hospital = :hospital " +
                "AND ls.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<LocationSd> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", itemUrlMain).bind("itemUrlSub", itemUrlSub).bind("hospital", hospitalCode);
            result = query.mapToBean(LocationSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        for (LocationSd locationSd : result) {

            locationSd.setContactNumbers(getLocationSdContact(version,languageList, locationSd.getUid()));

            locationSd.setHospitals(checkHospitalList(version,languageList,null, itemUrlMain, itemUrlSub, hospitalCode));
        }

        completed(methodName);
        return result;
    }

    private List<LocationSdContact> getLocationSdContact(Version version, List<String> languageList, String locationUid){
        final String methodName = "getLocationSdContact";
        start(methodName);
        String sql ="SELECT lsc.uid FROM location_sd ls " +
                "LEFT JOIN location_sd_contact lsc  ON ls.uid = lsc.location_sd_uid AND ls.status = lsc.status AND ls.language_code = lsc.language_code " +
                "WHERE ls.language_code IN(<languageList>) AND ls.uid = :uid AND ls.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<String> uidList = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bind("uid",locationUid).bindList("languageList", languageList);
            uidList = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        List<LocationSdContact> result = new ArrayList<>();

        for(String uid : uidList){
            if(uid != null && !uid.isEmpty()){
                LocationSdContact locationSdContact = getLocationSdContactByUid(version, languageList, uid);
                result.add(locationSdContact);
            }
        }

        completed(methodName);
        return result;
    }

    private LocationSdContact getLocationSdContactByUid(Version version, List<String> languageList, String uid){
        final String methodName = "getLocationSdContact";
        start(methodName);
        String sql ="SELECT lsc.contact_header, lsc.contact_number, lsc.display_order FROM location_sd_contact lsc " +
                "WHERE lsc.uid = :uid AND lsc.language_code IN(<languageList>) AND lsc.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        LocationSdContact result = new LocationSdContact();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("uid", uid);
            result = query.mapToBean(LocationSdContact.class).one();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }
    //END - Get Locations by Centre & Service

    //START - Get Locations by Hospital  and Location Type
    public  List<LocationSd> getLocationByHospitalAndLocation(Version version, List<String> languageList, List<String> hospitalCodes,List<String> locationTypes){
        final String methodName = "getLocationByHospital";
        start(methodName);
        List<LocationSd> result = new ArrayList<>();

        for (String hospital : hospitalCodes){
            for(String locationType : locationTypes){

                List<LocationSd> ls = getLocationSdHospital(version, languageList, hospital, locationType);
                for (LocationSd lsResult : ls){
                    lsResult.setContactNumbers(getLocationSdContact(version,languageList, lsResult.getUid()));
                    result.add(lsResult);
                }
            }

        }

        completed(methodName);
        return result;
    }

    public List<LocationSd> getLocationSdHospital(Version version, List<String> languageList, String hospitalCodes, String locationTypes){
        final String methodName = "getLocationSdHospital";
        start(methodName);
        String sql ="SELECT ls.uid, ls.language_code, ls.location_title,ls.image_url, ls.google_map_url, ls.address1, ls.address2, ls.city , ls.state, ls.postal_code, cor.cor , ls.whatsapp_number, ls.fax, ls.email, ls.display_order, ls.publish_flag, ls.created_dt, ls.modified_dt FROM location_sd ls " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid " +
                "LEFT JOIN location_sd_hospital lsh ON ls.uid  = lsh.location_sd_uid AND ls.status = lsh.status AND ls.language_code = lsh.language_code " +
                "LEFT JOIN location_type lt ON lt.uid = ls.location_type_uid  AND ls.status = lt.status AND ls.language_code = lt.language_code " +
                "LEFT JOIN hospital h ON lsh.hospital_uid  = h.uid  " +
                "WHERE ls.language_code IN(<languageList>) AND h.hospital = :hospitalCodes AND lt.location_type = :locationTypes " +
                "AND ls.publish_flag = {PUBLISHED} ";

        sql = getPublishVersion(version, sql);

        List<LocationSd> result = new ArrayList<>();

        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("hospitalCodes", hospitalCodes).bind("locationTypes", locationTypes);
            result = query.mapToBean(LocationSd.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }

        completed(methodName);
        return result;
    }

    //END - Get Locations by Hospital  and Location Type

    // for get Hospital

    private List<String> checkHospitalList(Version version, List<String> languageList, String itemUrls, String itemUrlMain,String itemUrlSub, String hospitalCode){
        List<String> result = new ArrayList<>();
        if(hospitalCode == null && itemUrlMain == null && itemUrlSub == null){
            result = getHospitalListByUrl(version, languageList, itemUrls, null);
        }else{
            result = getHospitalListByCentreService(version, languageList, itemUrlMain, itemUrlSub, hospitalCode);
        }

        return  result;
    }
    private List<String> getHospitalListByUrl(Version version, List<String> languageList, String itemUrls, String hospitalCode){
        final String methodName = "getHospitalList";
        start(methodName);
        String sql ="SELECT h.hospital  FROM location_sd ls   " +
                "LEFT JOIN location_sd_contact lsc  ON ls.uid = lsc.location_sd_uid AND ls.status = lsc.status AND ls.language_code = lsc.language_code   " +
                "LEFT JOIN country_of_residence cor ON ls.cor_uid  = cor.uid AND ls.status = cor.status AND ls.language_code = cor.language_code    " +
                "LEFT JOIN location_sd_hospital lsh ON ls.uid  = lsh.location_sd_uid AND lsc.status = lsh.status AND lsc.language_code = lsh.language_code   " +
                "LEFT JOIN hospital h ON lsh.hospital_uid  = h.uid  " +
                "WHERE ls.language_code IN(<languageList>) AND ls.item_url = :itemUrls " +
                "AND ls.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrls", itemUrls);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }

    private List<String> getHospitalListByCentreService(Version version, List<String> languageList, String itemUrlMain,String itemUrlSub, String hospitalCode){
        final String methodName = "getHospitalListByCentreService";
        start(methodName);
        String sql ="SELECT h.hospital FROM centre_service_sub_sd csss  " +
                "LEFT JOIN centre_service_main_sd csms ON csms.uid = csss.centre_service_main_sd_uid AND csss.status = csms.status AND csss.language_code = csms.language_code    " +
                "LEFT JOIN centre_service_sub_sd_location csssl ON csss.uid = csssl.centre_service_sub_sd_uid AND csss.status = csssl.status AND csss.language_code = csssl.language_code   " +
                "LEFT JOIN location_sd ls  ON ls.uid = csssl.location_uid AND ls.status = csssl.status AND ls.language_code = csssl.language_code  " +
                "LEFT JOIN centre_service_sub_sd_location_hospital cssslh ON csssl.uid  = cssslh.centre_service_sub_sd_location_uid AND cssslh.status = csssl.status AND cssslh.language_code = csssl.language_code   " +
                "LEFT JOIN hospital h ON cssslh.hospital_uid  = h.uid  " +
                "WHERE ls.language_code IN(<languageList>) AND csms.item_url = :itemUrlMain AND csss.item_url = :itemUrlSub  AND h.hospital = :hospital " +
                "AND ls.publish_flag = {PUBLISHED}";

        sql = getPublishVersion(version, sql);

        List<String> result = new ArrayList<>();
        try (Handle h = getHandle(); Query query = h.createQuery(sql)) {
            query.bindList("languageList", languageList).bind("itemUrlMain", itemUrlMain).bind("itemUrlSub", itemUrlSub).bind("hospital", hospitalCode);
            result = query.mapTo(String.class).list();

        } catch (Exception ex) {
            log.error(methodName, ex);
        }
        completed(methodName);
        return result;
    }
}
