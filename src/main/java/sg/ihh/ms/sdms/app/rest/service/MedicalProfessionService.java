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
import sg.ihh.ms.sdms.app.model.MedicalProfession;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.MedicalProfessionRepository;
import sg.ihh.ms.sdms.app.rest.model.MedicalProfessionListResponse;

@RestController
@RequestMapping(path = "medicalProfessions",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class MedicalProfessionService extends BaseService {

    @Autowired
    private MedicalProfessionRepository repository;

    @Autowired
    private ControlledListProcessor<MedicalProfession> processor;

    public MedicalProfessionService() {
        log = getLogger(getClass());
    }

    @GetMapping
    public MedicalProfessionListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<MedicalProfession> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        MedicalProfessionListResponse response = new MedicalProfessionListResponse(list);

        completed(methodName);
        return response;
    }
}
