package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.repository.CentreServiceSubSdRepository;
import sg.ihh.ms.sdms.app.rest.model.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "centreServiceS", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class CentreServiceSubService extends BaseService{
    @Autowired
    private CentreServiceSubSdRepository repository;
    public CentreServiceSubService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "locations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LocationSdListResponse getCentreServiceSubLocation(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceSubLocation";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<LocationSd> result = repository.getLocationByCentreService(Version.getVersion(version), languageList, centreServiceMUrl,centreServiceSUrl, hospitalCode);

        LocationSdListResponse response = new LocationSdListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "awards", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceSubAwardListResponse getCentreServiceSubAwardList(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceSubAwardList";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        CentreServiceSubAward result = repository.getCentreServiceSubAward(Version.getVersion(version), languageList, centreServiceMUrl,centreServiceSUrl, hospitalCode);

        CentreServiceSubAwardListResponse response = new CentreServiceSubAwardListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceSubCtaResponse getCentreServiceCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        CentreServiceSubCta result = repository.getCentreServiceSubCta(Version.getVersion(version), languageList, centreServiceSUrl, centreServiceMUrl, hospitalCode);

        CentreServiceSubCtaResponse response = new CentreServiceSubCtaResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "accordion", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceSubAccordionListResponse getCentreServiceAccordionList(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceAccordionList";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<CentreServiceSubAccordion> result = repository.getCentreServiceSubAccordion(Version.getVersion(version), languageList, centreServiceSUrl, centreServiceMUrl, hospitalCode);

        CentreServiceSubAccordionListResponse response = new CentreServiceSubAccordionListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "photoGallery", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceSubPhotoGalleryResponse getCentreServicePhotoGallery(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServicePhotoGallery";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        CentreServicePhotoGallery result = repository.getCentreServicePagePhotoGallery(Version.getVersion(version), languageList, centreServiceSUrl, centreServiceMUrl, hospitalCode);

        CentreServiceSubPhotoGalleryResponse response = new CentreServiceSubPhotoGalleryResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "bodySections", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceBodySectionListResponse getCentreServiceBodySection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceBodySection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<CentreServiceSubBodySection> result = repository.getCentreServiceSubBodySection(Version.getVersion(version), languageList, centreServiceSUrl, centreServiceMUrl, hospitalCode);

        CentreServiceBodySectionListResponse response = new CentreServiceBodySectionListResponse(result);

        completed(methodName);
        return response;
    }

    //START - Centre Service Sub Basic Detail Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceSubBasicDetailListResponse getContentSubMBasicDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getContentSubMBasicDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        CentreServiceSubBasicDetail result = repository.getCentreServiceSubBasicDetail(Version.getVersion(version), languageList, centreServiceSUrl, centreServiceMUrl, hospitalCode);

        CentreServiceSubBasicDetailListResponse response = new CentreServiceSubBasicDetailListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Centre Service Sub Basic Detail Block

    @RequestMapping(path = "relatedSpecialty", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceSubRelatedSpecialtyListResponse getCentreServiceSubRelatedSpecialty(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceSubRelatedSpecialty";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<CentreServiceSubRelatedSpecialties> result = repository.getCentreServiceRelatedSpecialties(Version.getVersion(version), languageList, centreServiceMUrl,centreServiceSUrl, hospitalCode);

        CentreServiceSubRelatedSpecialtyListResponse response = new CentreServiceSubRelatedSpecialtyListResponse(result);

        completed(methodName);
        return response;
    }

}
