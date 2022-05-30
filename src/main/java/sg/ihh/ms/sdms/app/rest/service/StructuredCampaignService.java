package sg.ihh.ms.sdms.app.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.repository.StructuredCampaignRepository;
import sg.ihh.ms.sdms.app.rest.model.StructuredCampaignAccordionListResponse;
import sg.ihh.ms.sdms.app.rest.model.StructuredCampaignCardCarouselResponse;
import sg.ihh.ms.sdms.app.rest.model.StructuredCampaignResponse;
import sg.ihh.ms.sdms.app.rest.model.StructuredPageBasicDetailListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "structuredCampaign", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class StructuredCampaignService extends BaseService {

    @Autowired
    private StructuredCampaignRepository repository;

    public StructuredCampaignService() {
        log = getLogger(this.getClass());
    }

    //START - Structured Campaign Basic Detail Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignResponse getStructuredCampaignBasicDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredPageUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getStructuredCampaignBasicDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredCampaignDetails result = repository.getStructuredCampaignDetails(Version.getVersion(version), languageList, structuredPageUrl, hospitalCode);

        StructuredCampaignResponse response = new StructuredCampaignResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Basic Detail Block

    //START - Structured Campaign Accordion Block
    @RequestMapping(path = "accordion", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignAccordionListResponse getStructuredCampaignAccordionList(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredPageUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getStructuredCampaignAccordionList";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredCampaignAccordion> result = repository.getStructuredCampaignAccordion(Version.getVersion(version), languageList, structuredPageUrl, hospitalCode);

        StructuredCampaignAccordionListResponse response = new StructuredCampaignAccordionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Accordion Block


    //START - Structured Campaign Basic Accordion Block
    @RequestMapping(path = "card", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignCardCarouselResponse getStructuredCampaignCardCarousel(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredPageUrl) {
        final String methodName = "getStructuredCampaignCardCarousel";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredCampaignCardCarousel result = repository.getStructuredCampaignCardCarousel(Version.getVersion(version), languageList, structuredPageUrl);

        StructuredCampaignCardCarouselResponse response = new StructuredCampaignCardCarouselResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Basic Detail Block
}
