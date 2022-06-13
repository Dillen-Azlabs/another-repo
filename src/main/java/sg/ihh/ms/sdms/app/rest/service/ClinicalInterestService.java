package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import sg.ihh.ms.sdms.app.model.ClinicalInterest;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.ClinicalInterestRepository;
import sg.ihh.ms.sdms.app.rest.model.ClinicalInterestListResponse;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "clinicalInterest", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ClinicalInterestService extends BaseService{
    @Autowired
    private ClinicalInterestRepository repository;

    @Autowired
    private ControlledListProcessor<ClinicalInterest> processor;

    public ClinicalInterestService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public ClinicalInterestListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") @NotNull String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ClinicalInterest> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        ClinicalInterestListResponse response = new ClinicalInterestListResponse(list);

        completed(methodName);
        return response;
    }

}
