package sg.ihh.ms.sdms.app.rest.service;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
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

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.util.*;

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
    public PacListResponse getPacByCountry(@RequestParam("version")@Pattern(regexp = "^(DRAFT|PUBLISHED)$",
             message = "Allowed Values : DRAFT, PUBLISHED") String version,  @RequestParam Map<String, String> requestParams) {
        final String methodName = "getPacByCountry";
        start(methodName);
        List<Pac> result = new ArrayList<>();
        PacListResponse pacListResponse = new PacListResponse(result);

        if (requestParams.containsKey("version") && requestParams.containsKey("languageCode")) {
            String languageCode = requestParams.get("languageCode");
            List<String> languageList = getLanguageList(languageCode);

            if (requestParams.containsKey("country")) {
                String country = requestParams.get("country");
                result = repository.searchByCountry(Version.getVersion(version), languageList, country);

            } else {
                result = repository.list(Version.getVersion(version), languageList);
            }

            result = processor.processList(result, languageCode);
            pacListResponse = new PacListResponse(result);
            String country = requestParams.get("country");
            pacListResponse.setCountry(country);

        }
        completed(methodName);
            return pacListResponse;
    }

}



