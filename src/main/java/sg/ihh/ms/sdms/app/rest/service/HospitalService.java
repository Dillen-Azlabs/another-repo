package sg.ihh.ms.sdms.app.rest.service;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.Hospital;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.HospitalRepository;
import sg.ihh.ms.sdms.app.rest.model.HospitalListResponse;

@RestController
@RequestMapping(path = "hospitals", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class HospitalService extends BaseService {

    @Autowired
    private HospitalRepository repository;

    @Autowired
    private ControlledListProcessor<Hospital> processor;

    public HospitalService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public HospitalListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Hospital> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        HospitalListResponse response = new HospitalListResponse(list);

        completed(methodName);
        return response;
    }
}
