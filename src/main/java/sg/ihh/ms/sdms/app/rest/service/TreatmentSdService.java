package sg.ihh.ms.sdms.app.rest.service;

import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.TreatmentCta;
import sg.ihh.ms.sdms.app.model.TreatmentWhatToExpect;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.TreatmentSdRepository;
import sg.ihh.ms.sdms.app.rest.model.TreatmentCtaListResponse;
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

    private StructuredDataProcessor<TreatmentWhatToExpect> twprocessor;

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
}
