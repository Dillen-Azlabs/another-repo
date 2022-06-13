package sg.ihh.ms.sdms.app.rest.service;

import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.ConditionRelatedData;
import sg.ihh.ms.sdms.app.model.SpecialtyExpertise;
import sg.ihh.ms.sdms.app.model.SpecialtyDetail;
import sg.ihh.ms.sdms.app.model.TreatmentCta;
import sg.ihh.ms.sdms.app.model.TreatmentRelatedData;
import sg.ihh.ms.sdms.app.model.TreatmentFaq;
import sg.ihh.ms.sdms.app.model.TreatmentExpertise;
import sg.ihh.ms.sdms.app.model.TreatmentDetail;
import sg.ihh.ms.sdms.app.model.TreatmentOverview;
import sg.ihh.ms.sdms.app.model.TreatmentWhatToExpect;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.TreatmentSdRepository;
import sg.ihh.ms.sdms.app.rest.model.SpecialtyExpertiseListResponse;
import sg.ihh.ms.sdms.app.rest.model.SpecialtyDetailListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentCtaListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentRelatedDataListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentFaqListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentExpertiseListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentDetailListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentOverviewListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentWhatToExpectListResponse;


import java.util.List;

@RestController
@RequestMapping(path = "treatments", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class TreatmentSdService extends BaseService{
    @Autowired
    private TreatmentSdRepository repository;

    @Autowired
    private StructuredDataProcessor<TreatmentCta> tcprocessor;

    public TreatmentSdService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TreatmentCtaListResponse getTreatmentCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl) {
        final String methodName = "getTreatmentCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        TreatmentCta result = repository.getTreatmentCta(Version.getVersion(version), languageList, treatmentUrl);

        TreatmentCtaListResponse response = new TreatmentCtaListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "relatedData", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TreatmentRelatedDataListResponse getTreatmentRelatedData(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl) {
        final String methodName = "getTreatmentRelatedData";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        TreatmentRelatedData result = repository.getTreatmentRelatedData(Version.getVersion(version), languageList, treatmentUrl);


        TreatmentRelatedDataListResponse response = new TreatmentRelatedDataListResponse(result);

        completed(methodName);
        return response;
    }
    //START - Treatment FAQ Block
    @RequestMapping(path = "faq", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TreatmentFaqListResponse getTreatmentFaq(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl) {
        final String methodName = "getConditionFaq";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        TreatmentFaq result = repository.getTreatmentFaq(Version.getVersion(version), languageList, treatmentUrl);

        TreatmentFaqListResponse response = new TreatmentFaqListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Treatment FAQ Block
    //START - Treatment Expertise Block
    @RequestMapping(path = "expertise", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TreatmentExpertiseListResponse getTreatmentExpertise(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getTreatmentExpertise";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        TreatmentExpertise result = repository.getTreatmentExpertise(Version.getVersion(version), languageList, treatmentUrl, hospitalCode);

        TreatmentExpertiseListResponse response = new TreatmentExpertiseListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Treatment Expertise Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TreatmentDetailListResponse getTreatmentDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getTreatmentDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        TreatmentDetail result = repository.getTreatmentDetail(Version.getVersion(version), languageList, treatmentUrl,hospitalCode);

        TreatmentDetailListResponse response = new TreatmentDetailListResponse(result);

        completed(methodName);
        return response;
    }
    //START - Treatment Overview Block
    @RequestMapping(path = "overview", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TreatmentOverviewListResponse getTreatmentOverview(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl) {
        final String methodName = "getTreatmentOverview";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        TreatmentOverview result = repository.getTreatmentOverview(Version.getVersion(version), languageList, treatmentUrl);

        TreatmentOverviewListResponse response = new TreatmentOverviewListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Treatment Overview Block
    //START - Treatment What to Expect Block
    @RequestMapping(path = "whatToExpect", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TreatmentWhatToExpectListResponse getTreatmentWhatToExpect(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl) {
        final String methodName = "getTreatmentWhatToExpect";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        TreatmentWhatToExpect result = repository.getTreatmentWhatToExpect(Version.getVersion(version), languageList, treatmentUrl);

        TreatmentWhatToExpectListResponse response = new TreatmentWhatToExpectListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Treatment What to Expect Block
}
