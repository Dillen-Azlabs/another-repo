package sg.ihh.ms.sdms.app.rest.service;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.ContentHubMainBasicDetail;
import sg.ihh.ms.sdms.app.model.ContentHubMainCta;
import sg.ihh.ms.sdms.app.model.ContentHubMainBodySection;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.ContentHubMainSdRepository;
import sg.ihh.ms.sdms.app.rest.model.ContentHubMainBasicDetailListResponse;
import sg.ihh.ms.sdms.app.rest.model.ContentHubMainCtaListResponse;
import sg.ihh.ms.sdms.app.rest.model.ContentHubMainBodySectionListResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(path = "contentHubM", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ContentHubMainSdService extends BaseService{

    @Autowired
    private ContentHubMainSdRepository repository;

    @Autowired
    private StructuredDataProcessor<ContentHubMainBasicDetail> bdprocessor;

    @Autowired
    private StructuredDataProcessor<ContentHubMainBodySection> bsprocessor;

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

        ContentHubMainBasicDetail result = repository.getContentHubMainBasicDetail(Version.getVersion(version), languageList, contentHubMUrl,hospitalCode);

        ContentHubMainBasicDetailListResponse response = new ContentHubMainBasicDetailListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main Basic Detail Block

    //START - Content Hub Main Body Section Block
    @RequestMapping(path = "bodySections", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainBodySectionListResponse getContentHubMainBodySection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubMUrl") String contentHubMUrl,
            @RequestParam("sectionNumber") @Range(min = 1, max = 2,
                    message = "Allowed Values : 1, 2") int sectionNumber){
        final String methodName = "getContentHubMainBodySection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ContentHubMainBodySection> result = repository.getContentHubMainBodySection(Version.getVersion(version), languageList, contentHubMUrl, sectionNumber);

        result = bsprocessor.processList(result, languageCode);

        ContentHubMainBodySectionListResponse response = new ContentHubMainBodySectionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main Body Section Block

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

}
