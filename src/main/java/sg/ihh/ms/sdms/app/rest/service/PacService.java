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

    @RequestMapping(path = "countr", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
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

    @RequestMapping(path = "country", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PacListResponse getPacByCountry(@RequestParam  Map<String,String> allParams) {

        int index = allParams.entrySet().size();
        List<String> value = new ArrayList<String>();

        PacParam pacParam = new PacParam();



        for(Map.Entry<String, String> param : allParams.entrySet()){
            String lang = param.getValue();


            value.add(lang);
        }


        if(index == 3){
            pacParam.setLanguageListCode(value.get(0));
            pacParam.setVersion(value.get(1));
            pacParam.setCountry(value.get(2));

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.usingContext().getValidator();

            Set constrains = validator.validate(pacParam);

            System.out.println( constrains );
            Version version = Version.getVersion(pacParam.getVersion());
            List<String> languageList = getLanguageList(pacParam.getLanguageListCode());
            List<Pac> resultPac = repository.searchByCountry(version, languageList, pacParam.getCountry());
            PacListResponse response = new PacListResponse(resultPac);
            response.setCountry(value.get(2));
            return  response;
        }else{
            pacParam.setLanguageListCode(value.get(0));
            pacParam.setVersion(value.get(1));
            Version version = Version.getVersion(pacParam.getVersion());
            List<String> languageList = getLanguageList(pacParam.getLanguageListCode());
            List<Pac> resultAll = repository.list(version, languageList);
            return  new PacListResponse(resultAll);
        }
    }


}

class PacParam {
    private String languageListCode;

    @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED")
    private String version;

    private String country;

    public PacParam() {

    }

    public String getLanguageListCode() {
        return languageListCode;
    }

    public void setLanguageListCode(String languageListCode) {
        this.languageListCode = languageListCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
