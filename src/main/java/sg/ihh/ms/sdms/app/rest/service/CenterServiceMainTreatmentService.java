package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.CentreServiceMain;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.CentreServiceMainSdRepository;
import sg.ihh.ms.sdms.app.rest.model.CentreServiceMainListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "treatment", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class CenterServiceMainTreatmentService extends BaseService{
    @Autowired
    private CentreServiceMainSdRepository repository;
    public CenterServiceMainTreatmentService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "relatedCentreServiceM", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceMainListResponse getCentreServiceMainTreatment(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("treatmentUrl") String treatmentUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceMainTreatment";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<CentreServiceMain> result = repository.getCentreServiceMainTreatment(Version.getVersion(version), languageList, treatmentUrl, hospitalCode);

        CentreServiceMainListResponse response = new CentreServiceMainListResponse(result);

        completed(methodName);
        return response;
    }
}
