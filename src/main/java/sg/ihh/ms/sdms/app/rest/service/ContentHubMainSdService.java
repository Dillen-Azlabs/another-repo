package sg.ihh.ms.sdms.app.rest.service;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.ContentHubMainSdRepository;
import sg.ihh.ms.sdms.app.rest.model.*;


import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "contentHubM", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ContentHubMainSdService extends BaseService {

    @Autowired
    private ContentHubMainSdRepository repository;

    @Autowired
    private StructuredDataProcessor<ContentHubMainBasicDetail> bdprocessor;

    @Autowired
    private StructuredDataProcessor<ContentHubMainIconContent> icprocessor;


    public ContentHubMainSdService() {
        log = getLogger(this.getClass());
    }

    //START - Content Hub Main Basic Detail Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainBasicDetailListResponse getContentHubMBasicDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubMUrl") String contentHubMUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getContentHubMBasicDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ContentHubMainBasicDetail result = repository.getContentHubMainBasicDetail(Version.getVersion(version), languageList, contentHubMUrl, hospitalCode);

        ContentHubMainBasicDetailListResponse response = new ContentHubMainBasicDetailListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main Basic Detail Block

    //START - Content Hub Main Care Area & Specialist Block
    @RequestMapping(path = "careAreaSpecialist", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainCareAreaSpecialistListResponse getContentHubMainCareAreaSpecialist(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubMUrl") String contentHubMUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getContentHubMainCareAreaSpecialist";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ContentHubMainCareAreaSpecialist result = repository.getContentHubMainCareAreaSpecialist(Version.getVersion(version), languageList, contentHubMUrl, hospitalCode);

        ContentHubMainCareAreaSpecialistListResponse response = new ContentHubMainCareAreaSpecialistListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main Care Area & Specialist Block

    //START - Content Hub Main CTA  Block
    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainCtaListResponse getContentHubMainCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubMUrl") String contentHubMUrl) {
        final String methodName = "getContentHubMainCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ContentHubMainCta result = repository.getContentHubMainCta(Version.getVersion(version), languageList, contentHubMUrl);

        ContentHubMainCtaListResponse response = new ContentHubMainCtaListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main CTA  Block

    //START - Content Hub Main Icon Content Block
    @RequestMapping(path = "iconContent", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainIconContentListResponse getContentHubMainBodySection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubMUrl") String contentHubMUrl) {
        final String methodName = "getContentHubMainBodySection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ContentHubMainIconContent> result = repository.getContentHubMainIconContent(Version.getVersion(version), languageList, contentHubMUrl);

        result = icprocessor.processList(result, languageCode);

        ContentHubMainIconContentListResponse response = new ContentHubMainIconContentListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main Icon Content Bloc

    //START - Content Hub Main Award Block
    @RequestMapping(path = "award", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainAwardListResponse getAward(@RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
            message = "Allowed Values : DRAFT, PUBLISHED") String version, @RequestParam Map<String, String> requestParams) {
        final String methodName = "getAward";
        start(methodName);
        List<ContentHubMainAward> result = new ArrayList<>();
        ContentHubMainAwardListResponse contentHubMainAwardListResponse = new ContentHubMainAwardListResponse(result);

        if (requestParams.containsKey("languageCode") && requestParams.containsKey("contentHubMUrl") && requestParams.containsKey("hospitalCode") && requestParams.containsKey("country")) {
            String languageCode = requestParams.get("languageCode");
            String contentHubMUrl = requestParams.get("contentHubMUrl");
            String hospitalCode = requestParams.get("hospitalCode");
            String country = requestParams.get("country");
            List<String> languageList = getLanguageList(languageCode);

            if (hospitalCode.equals("ALL")) {

                result = repository.list(Version.getVersion(version), languageList, contentHubMUrl, country);
                contentHubMainAwardListResponse = new ContentHubMainAwardListResponse(result);
                return contentHubMainAwardListResponse;

            } else {
                result = repository.getContentHubMainAward(Version.getVersion(version), languageList, contentHubMUrl, hospitalCode, country);
            }
            contentHubMainAwardListResponse = new ContentHubMainAwardListResponse(result);

        }
        completed(methodName);
        return contentHubMainAwardListResponse;
    }

    //END - Content Hub Main Award Block
    //START - Content Hub Main Body Section Block
    @RequestMapping(path = "bodySections", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainBodySectionListResponse getContentHubMainBodySection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubMUrl") String contentHubMUrl,
            @RequestParam("sectionNumber") @Range(min = 1, max = 2,
                    message = "Allowed Values : 1, 2") int sectionNumber) {
        final String methodName = "getContentHubMainBodySection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ContentHubMainBodySection> result = repository.getContentHubMainBodySection(Version.getVersion(version), languageList, contentHubMUrl, sectionNumber);


        ContentHubMainBodySectionListResponse response = new ContentHubMainBodySectionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main Body Section Block
}







