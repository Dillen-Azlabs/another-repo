package sg.ihh.ms.sdms.app.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.repository.StructuredCampaignRepository;
import sg.ihh.ms.sdms.app.rest.model.*;

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


    //START - Structured Campaign Faq Block
    @RequestMapping(path = "faq", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignFaqResponse getStructuredCampaignFaq(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredPageUrl,
            @RequestParam("country") String country) {
        final String methodName = "getStructuredCampaignFaq";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredCampaignFaq> result = repository.getStructuredCampaignFaq(Version.getVersion(version), languageList, structuredPageUrl,country);

        StructuredCampaignFaqResponse response = new StructuredCampaignFaqResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Faq Block

    //START - Structured Campaign By Specialty Block
    @RequestMapping(path = "specialty", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignSdResponse getStructuredCampaignBySpecialty(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospital) {
        final String methodName = "getStructuredCampaignBySpecialty";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredCampaignSd> result = repository.getStructuredCampaignBySpecialty(Version.getVersion(version), languageList, specialtyUrl,hospital);

        StructuredCampaignSdResponse response = new StructuredCampaignSdResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Faq Block

    //START - Structured Campaign Cta Section Block
    @RequestMapping(path = "ctaSection", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignCTASectionResponse getStructuredCampaignCtaSection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredCampaignUrl) {
        final String methodName = "getStructuredCampaignCtaSection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredCampaignCTASection result = repository.getStructuredCampaignCtaSection(Version.getVersion(version), languageList, structuredCampaignUrl);

        StructuredCampaignCTASectionResponse response = new StructuredCampaignCTASectionResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Cta Section Block


    //START - Structured Campaign Cta Block
    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignCtaResponse getStructuredCampaignCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredCampaignUrl,
            @RequestParam("country") String country) {
        final String methodName = "getStructuredCampaignCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredCampaignCTA result = repository.getStructuredCampaignCta(Version.getVersion(version), languageList, structuredCampaignUrl, country);

        StructuredCampaignCtaResponse response = new StructuredCampaignCtaResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Cta Block
    //END - Structured Campaign Specialty Block

    //START - Structured Campaign By Condition Block
    @RequestMapping(path = "condition", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignSdResponse getStructuredCampaignByCondition(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("conditionUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospital) {
        final String methodName = "getStructuredCampaignByCondition";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredCampaignSd> result = repository.getStructuredCampaignByCondition(Version.getVersion(version), languageList, specialtyUrl,hospital);

        StructuredCampaignSdResponse response = new StructuredCampaignSdResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Condition Block


    //START - Structured Campaign By Test & Treatment Block
    @RequestMapping(path = "treatment", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignSdResponse getStructuredCampaignByTestTreatment(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospital) {
        final String methodName = "getStructuredCampaignByTestTreatment";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredCampaignSd> result = repository.getStructuredCampaignByTestTreatment(Version.getVersion(version), languageList, specialtyUrl,hospital);

        StructuredCampaignSdResponse response = new StructuredCampaignSdResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Campaign Test & Treatment Block
}
