package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.PacRepository;
import sg.ihh.ms.sdms.app.rest.model.PacListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "pac", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class PacService extends BaseService {

    @Autowired
    private PacRepository repository;

    @Autowired
    private StructuredDataProcessor<Pac> processor;

    public PacService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "country", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PacListResponse getPacByCountry(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("country") String country) {
        final String methodName = "getPacByCountry";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Pac> result = repository.searchByCountry(Version.getVersion(version), languageList, country);

        result = processor.processList(result, languageCode);

        PacListResponse response = new PacListResponse(result);

        response.setCountry(country);

        completed(methodName);
        return response;
    }
}
