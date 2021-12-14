package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.ihh.ms.sdms.app.model.BodyPartLevel1;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.BodyPartLevel1Repository;
import sg.ihh.ms.sdms.app.rest.model.BodyPartLevel1ListResponse;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@RestController
@RequestMapping(path = "bodyPartsLvl1", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class BodyPartLevel1Service extends BaseService{
    @Autowired
    private BodyPartLevel1Repository repository;

    @Autowired
    private ControlledListProcessor<BodyPartLevel1> processor;

    public BodyPartLevel1Service() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public BodyPartLevel1ListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") @NotNull String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<BodyPartLevel1> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        BodyPartLevel1ListResponse response = new BodyPartLevel1ListResponse(list);

        completed(methodName);
        return response;
    }
}



