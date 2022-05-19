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
import sg.ihh.ms.sdms.app.rest.model.StructuredCampaignBodySectionsResponse;
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

    //START - Structured Page Basic Detail Block
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
    //END - Structured Page Basic Detail Block

    //START - Structured Page Basic Accordion Block
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
    //END - Structured Page Basic Detail Block

    //START - Structured Campaign Body Sections Block
    @RequestMapping(path = "bodySections", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignBodySectionsResponse getStructuredCampaignBodySections(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredPageUrl,
            @RequestParam("country") String country,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getStructuredCampaignBodySections";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredCampaignBodySections> result = repository.getStructuredCampaignBodySections(Version.getVersion(version), languageList, structuredPageUrl,country, hospitalCode);

        StructuredCampaignBodySectionsResponse response = new StructuredCampaignBodySectionsResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Body Section Block
}
