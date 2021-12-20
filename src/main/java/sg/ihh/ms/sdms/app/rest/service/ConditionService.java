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
    private StructuredDataProcessor<ConditionCta> processor;

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

        result = processor.processList(result, languageCode);

        ConditionCtaListResponse response = new ConditionCtaListResponse(result);

        completed(methodName);
        return response;
    }
}
