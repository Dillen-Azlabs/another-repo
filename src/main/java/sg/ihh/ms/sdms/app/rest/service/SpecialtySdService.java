package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.SpecialtySdRepository;
import sg.ihh.ms.sdms.app.rest.model.*;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "specialties", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class SpecialtySdService extends BaseService{
    @Autowired
    private SpecialtySdRepository repository;

    @Autowired
    private StructuredDataProcessor<SpecialtyDetail> sdProcessor;

    @Autowired
    private StructuredDataProcessor<SpecialtyCta> scProcessor;

    @Autowired
    private StructuredDataProcessor<SpecialtyOverview> soProcessor;

    @Autowired
    private StructuredDataProcessor<SpecialtyRelatedCondition> srcProcessor;

    @Autowired
    private StructuredDataProcessor<SpecialtyRelatedTreatment> srtProcessor;

    @Autowired
    private StructuredDataProcessor<SpecialtyExpertise> seProcessor;

    @Autowired
    private StructuredDataProcessor<SpecialtyFaq> sfProcessor;

    public SpecialtySdService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyDetailListResponse getSpecialtyDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getSpecialtyDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        SpecialtyDetail result = repository.getSpecialtyDetail(Version.getVersion(version), languageList, specialtyUrl,hospitalCode);

//        result = sdProcessor.processList(result, languageCode);

        SpecialtyDetailListResponse response = new SpecialtyDetailListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyCtaListResponse getSpecialtyCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl) {
        final String methodName = "getSpecialtyCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        SpecialtyCta result = repository.getSpecialtyCta(Version.getVersion(version), languageList, specialtyUrl);

//        result = scProcessor.processList(result, languageCode);

        SpecialtyCtaListResponse response = new SpecialtyCtaListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "overview", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyOverviewListResponse getSpecialtyOverview(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getSpecialtyOverview";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

//        SpecialtyOverview result = repository.getSpecialtyOverview(Version.getVersion(version), languageList, specialtyUrl, hospitalCode);

        SpecialtyOverview result = repository.getSpecialtyOverview(Version.getVersion(version), languageList, specialtyUrl, hospitalCode);
//        result = soProcessor.processList(result, languageCode);

        SpecialtyOverviewListResponse response = new SpecialtyOverviewListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "relatedConditionsContent", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyRelatedConditionListResponse getSpecialtyRelatedCondition(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getSpecialtyRelatedCondition";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        SpecialtyRelatedCondition result = repository.getSpecialtyRelatedCondition(Version.getVersion(version), languageList, specialtyUrl,hospitalCode);

//        result = srcProcessor.processList(result, languageCode);

        SpecialtyRelatedConditionListResponse response = new SpecialtyRelatedConditionListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "relatedTreatmentsContent", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyRelatedTreatmentListResponse getSpecialtyRelatedTreatment(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getSpecialtyRelatedTreatment";
        start(methodName);



        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        SpecialtyRelatedTreatment result = repository.getSpecialtyRelatedTreatment(Version.getVersion(version), languageList, specialtyUrl,hospitalCode);

//        result = srtProcessor.processList(result, languageCode);

        SpecialtyRelatedTreatmentListResponse response = new SpecialtyRelatedTreatmentListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "expertise", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyExpertiseListResponse getSpecialtyExpertise(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getSpecialtyExpertise";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        SpecialtyExpertise result = repository.getSpecialtyExpertise(Version.getVersion(version), languageList, specialtyUrl,hospitalCode);

//        result = seProcessor.processList(result, languageCode);

        SpecialtyExpertiseListResponse response = new SpecialtyExpertiseListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "faq", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyFaqListResponse getSpecialtyFaq(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getSpecialtyFaq";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        SpecialtyFaq result = repository.getSpecialtyFaq(Version.getVersion(version), languageList, specialtyUrl,hospitalCode);

//        result = sfProcessor.processList(result, languageCode);

        SpecialtyFaqListResponse response = new SpecialtyFaqListResponse(result);

        completed(methodName);
        return response;
    }
    @RequestMapping(path = "relatedData", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyRelatedDataListResponse getSpecialtyRelatedData(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam Map<String, String> requestParams) {
        final String methodName = "getSpecialtyRelatedData";
        start(methodName);

        SpecialtyRelatedData result = new SpecialtyRelatedData();
        SpecialtyRelatedDataListResponse response = new SpecialtyRelatedDataListResponse(result);


        if(requestParams.containsKey("specialtyUrl")){
            String specialtyUrl = requestParams.get("specialtyUrl");

            if (requestParams.containsKey("languageCode")){
                String languageCode = requestParams.get("languageCode");
                List<String> languageList = getLanguageList(languageCode);
                if (languageCode.isEmpty()){
                    languageList = getLanguageList("EN");
                    result = repository.getSpecialtyRelatedData(Version.getVersion(version), languageList, specialtyUrl);
                    response = new SpecialtyRelatedDataListResponse(result);
                    return response;
                }
                result = repository.getSpecialtyRelatedData(Version.getVersion(version), languageList, specialtyUrl);
                response = new SpecialtyRelatedDataListResponse(result);
                return response;

            }
            result = repository.getSpecialtyRelatedData(Version.getVersion(version), getLanguageList("EN"), specialtyUrl);
            response = new SpecialtyRelatedDataListResponse(result);
            return response;
        }


        completed(methodName);
        return response;
    }
}
