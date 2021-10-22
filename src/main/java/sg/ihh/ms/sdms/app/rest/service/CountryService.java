package sg.ihh.ms.sdms.app.rest.service;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.Country;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.CountryRepository;
import sg.ihh.ms.sdms.app.rest.model.CountryListResponse;

@RestController
@RequestMapping(path = "countries", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class CountryService extends BaseService {

    @Autowired
    private CountryRepository repository;

    @Autowired
    private ControlledListProcessor<Country> processor;

    public CountryService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public CountryListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") @NotNull String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Country> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        CountryListResponse response = new CountryListResponse(list);

        completed(methodName);
        return response;
    }
}
