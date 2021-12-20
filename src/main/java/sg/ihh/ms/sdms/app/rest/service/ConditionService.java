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

@RestController
@RequestMapping(path = "conditions", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ConditionService extends BaseService{

    @Autowired
    private ConditionRepository repository;

    @Autowired
    private StructuredDataProcessor<ConditionCta> ccProcessor;

    @Autowired
    private StructuredDataProcessor<ConditionSymptom> csProcessor;

    @Autowired
    private StructuredDataProcessor<ConditionExpertise> ceProcessor;

    public ConditionService() {
        log = getLogger(this.getClass());
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

        List<ConditionCta> result = repository.getCta(Version.getVersion(version), languageList, conditionUrl);

        result = ccProcessor.processList(result, languageCode);

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

        List<ConditionSymptom> result = repository.getSymptom(Version.getVersion(version), languageList, conditionUrl, hospitalCode);

        result = csProcessor.processList(result, languageCode);

        ConditionSymptomListResponse response = new ConditionSymptomListResponse(result);

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

        List<ConditionExpertise> result = repository.getExpertise(Version.getVersion(version), languageList, conditionUrl,hospitalCode);

        result = ceProcessor.processList(result, languageCode);

        ConditionExpertiseListResponse response = new ConditionExpertiseListResponse(result);

        completed(methodName);
        return response;
    }

}
