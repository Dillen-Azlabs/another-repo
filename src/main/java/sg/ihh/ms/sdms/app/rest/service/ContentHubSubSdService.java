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
import sg.ihh.ms.sdms.app.repository.*;
import sg.ihh.ms.sdms.app.rest.model.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "contentHubS", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ContentHubSubSdService extends BaseService{

    @Autowired
    private ContentHubSubSdRepository repository;

    @Autowired
    private StructuredDataProcessor<ContentHubSubCta> cprocessor;


    public ContentHubSubSdService() {
        log = getLogger(this.getClass());
    }

    //START - Content Hub Sub CTA  Block
    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubSubCtaListResponse getContentHubSubCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubSUrl") String contentHubSUrl,
            @RequestParam("contentHubMUrl") String contentHubMUrl) {
        final String methodName = "getContentHubSubCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ContentHubSubCta result = repository.getContentHubSubCta(Version.getVersion(version), languageList, contentHubSUrl, contentHubMUrl);

        ContentHubSubCtaListResponse response = new ContentHubSubCtaListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Sub CTA  Block

    //START - Content Hub Sub Basic Detail Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubSubBasicDetailListResponse getContentSubMBasicDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubSUrl") String contentHubSUrl,
            @RequestParam("contentHubMUrl") String contentHubMUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getContentSubMBasicDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ContentHubSubBasicDetail result = repository.getContentHubSubBasicDetail(Version.getVersion(version), languageList, contentHubSUrl, contentHubMUrl, hospitalCode);

        ContentHubSubBasicDetailListResponse response = new ContentHubSubBasicDetailListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Sub Basic Detail Block

    //START - Content Hub Sub Body Section Block
    @RequestMapping(path = "bodySections", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubSubBodySectionListResponse getContentHubSubBodySection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubSUrl") String contentHubSUrl,
            @RequestParam("contentHubMUrl") String contentHubMUrl) {
        final String methodName = "getContentHubSubBodySection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ContentHubSubBodySection> result = repository.getContentHubSubBodySection(Version.getVersion(version), languageList, contentHubSUrl, contentHubMUrl);


        ContentHubSubBodySectionListResponse response = new ContentHubSubBodySectionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Sub Body Section Block

    //START - Content Hub Sub Accordion Block
    @RequestMapping(path = "accordion", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubSubAccordionListResponse getContentHubSubAccordion(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubSUrl") String contentHubSUrl,
            @RequestParam("contentHubMUrl") String contentHubMUrl){
        final String methodName = "getContentHubSubAccordion";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ContentHubSubAccordion> result = repository.getContentHubSubAccordion(Version.getVersion(version), languageList, contentHubSUrl, contentHubMUrl);

        ContentHubSubAccordionListResponse response = new ContentHubSubAccordionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Sub Accordion Block
}
