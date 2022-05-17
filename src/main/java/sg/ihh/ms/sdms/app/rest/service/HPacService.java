package sg.ihh.ms.sdms.app.rest.service;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.HPacRepository;
import sg.ihh.ms.sdms.app.rest.model.HPacListResponse;

@RestController
@RequestMapping(
        path = "hpac/country",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
)
@Validated
public class HPacService extends BaseService {

    @Autowired
    private HPacRepository repository;
    @Autowired
    private StructuredDataProcessor<Pac> processor;

    public HPacService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public HPacListResponse getPacList(
            @RequestParam("languageCode") @NotBlank
            String languageCode,
            @RequestParam("version") @NotBlank @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED")
            String version,
            @RequestParam(value = "country", required = false)
            String country
    ) {
        final String methodName = "getHPacByCountry";
        start(methodName);

        List<Pac> pacList = repository.list(
                Version.getVersion(version),
                getLanguageList(languageCode),
                country);

        pacList = processor.processList(pacList, languageCode);

        HPacListResponse response = new HPacListResponse(pacList);
        if (country == null || country.trim().isEmpty()) {
            response.setCountry(null);
        } else {
            response.setCountry(country);
        }

        completed(methodName);
        return response;
    }
}
