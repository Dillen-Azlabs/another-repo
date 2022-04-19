package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.CentreServiceMainSdRepository;
import sg.ihh.ms.sdms.app.rest.model.*;


import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "centreServiceM", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class CentreServiceMainSdService extends BaseService{
    @Autowired
    private CentreServiceMainSdRepository repository;

    public CentreServiceMainSdService() {
        log = getLogger(this.getClass());
    }

    //START - Centre Service Main CTA Section Block
    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CentreServiceMainCtaListResponse getCentreServiceMainCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl) {
        final String methodName = "getCentreServiceMainCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        CentreServiceMainCta result = repository.getCentreServiceCta(Version.getVersion(version), languageList, centreServiceMUrl);

        CentreServiceMainCtaListResponse response = new CentreServiceMainCtaListResponse(result);

        completed(methodName);
        return response;
    }
    //START - Centre Service Main CTA Section Block
}
