package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.ConditionRepository;
import sg.ihh.ms.sdms.app.rest.model.*;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "conditions", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ConditionService extends BaseService{

    @Autowired
    private ConditionRepository repository;

    @Autowired
    private StructuredDataProcessor<ConditionDetail> cdeProcessor;

    @Autowired
    private StructuredDataProcessor<ConditionCta> ccProcessor;

    @Autowired
    private StructuredDataProcessor<ConditionSymptom> csProcessor;

    @Autowired
    private StructuredDataProcessor<ConditionDiagnosis> cdprocessor;

    @Autowired
    private StructuredDataProcessor<ConditionExpertise> ceProcessor;

    @Autowired
    private StructuredDataProcessor<ConditionFaq> cfProcessor;

    @Autowired
    private StructuredDataProcessor<ConditionRelatedData> crdProcessor;

    public ConditionService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ConditionDetailListResponse getConditionDetails(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("conditionUrl") String conditionUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getConditionDetails";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ConditionDetail result = repository.getDetails(Version.getVersion(version), languageList, conditionUrl, hospitalCode);

//        result = cdeProcessor.processList(result, languageCode);

        ConditionDetailListResponse response = new ConditionDetailListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ConditionCtaListResponse getConditionCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("conditionUrl") String conditionUrl) {
        final String methodName = "getConditionCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ConditionCta result = repository.getCta(Version.getVersion(version), languageList, conditionUrl);

//        result = ccProcessor.processList(result, languageCode);

        ConditionCtaListResponse response = new ConditionCtaListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "symptoms", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ConditionSymptomListResponse getConditionSymptom(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("conditionUrl") String conditionUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getConditionSymptom";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ConditionSymptom result = repository.getSymptom(Version.getVersion(version), languageList, conditionUrl, hospitalCode);

//        result = csProcessor.processList(result, languageCode);

        ConditionSymptomListResponse response = new ConditionSymptomListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "diagnosis", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ConditionDiagnosisListResponse getConditionDiagnosis(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("conditionUrl") String conditionUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getConditionDiagnosis";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ConditionDiagnosis result = repository.getDiagnosis(Version.getVersion(version), languageList, conditionUrl,hospitalCode);

//        result = cdprocessor.processList(result, languageCode);

        ConditionDiagnosisListResponse response = new ConditionDiagnosisListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "expertise", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ConditionExpertiseListResponse getConditionExpertise(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("conditionUrl") String conditionUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getConditionExpertise";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ConditionExpertise result = repository.getConditionExpertise(Version.getVersion(version), languageList, conditionUrl,hospitalCode);

//        result = ceProcessor.processList(result, languageCode);

        ConditionExpertiseListResponse response = new ConditionExpertiseListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "faqs", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ConditionFaqListResponse getConditionFaq(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("conditionUrl") String conditionUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getConditionFaq";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ConditionFaq result = repository.getConditionFaq(Version.getVersion(version), languageList, conditionUrl,hospitalCode);

//        result = cfProcessor.processList(result, languageCode);

        ConditionFaqListResponse response = new ConditionFaqListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "relatedData", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ConditionRelatedDataListResponse getConditionRelatedData(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam Map<String, String> requestParams) {
        final String methodName = "getConditionRelatedData";
        start(methodName);

        ConditionRelatedData result = new ConditionRelatedData();
        ConditionRelatedDataListResponse response = new ConditionRelatedDataListResponse(result);

        if(requestParams.containsKey("conditionUrl")){
            String conditionUrl = requestParams.get("conditionUrl");

            if (requestParams.containsKey("languageCode")){
                String languageCode = requestParams.get("languageCode");
                List<String> languageList = getLanguageList(languageCode);
                if (languageCode.isEmpty()){
                    languageList = getLanguageList("EN");
                    result = repository.getConditionRelatedData(Version.getVersion(version), languageList, conditionUrl);
                    response = new ConditionRelatedDataListResponse(result);
                    return response;
                }
                result = repository.getConditionRelatedData(Version.getVersion(version), languageList, conditionUrl);
                response = new ConditionRelatedDataListResponse(result);
                return response;

            }
            result = repository.getConditionRelatedData(Version.getVersion(version), getLanguageList("EN"), conditionUrl);
            response = new ConditionRelatedDataListResponse(result);
            return response;
        }
        completed(methodName);
        return response;
    }

}
