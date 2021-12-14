package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.ihh.ms.sdms.app.model.ChildSpecialty;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.model.ChildSpecialtyRepository;
import sg.ihh.ms.sdms.app.rest.model.ChildSpecialtyListResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "childSpecialties", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ChildSpecialtyService extends BaseService{
    @Autowired
    private ChildSpecialtyRepository repository;

    @Autowired
    private ControlledListProcessor<ChildSpecialty> processor;

    public ChildSpecialtyService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public ChildSpecialtyListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") @NotNull String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ChildSpecialty> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        ChildSpecialtyListResponse response = new ChildSpecialtyListResponse(list);

        completed(methodName);
        return response;
    }

}
