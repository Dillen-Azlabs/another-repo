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
import sg.ihh.ms.sdms.app.model.Specialty;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.SpecialtyRepository;
import sg.ihh.ms.sdms.app.rest.model.SpecialtyListResponse;

@RestController
@RequestMapping(path = "specialties", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class SpecialtyService extends BaseService {

    @Autowired
    private SpecialtyRepository repository;

    @Autowired
    private ControlledListProcessor<Specialty> processor;

    public SpecialtyService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public SpecialtyListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Specialty> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        SpecialtyListResponse response = new SpecialtyListResponse(list);

        completed(methodName);
        return response;
    }
}
