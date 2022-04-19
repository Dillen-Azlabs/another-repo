package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.LocationSd;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.model.CentreServiceSubSdRepository;
import sg.ihh.ms.sdms.app.rest.model.LocationSdListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "centreServiceS", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class CenterServiceSubService extends BaseService{
    @Autowired
    private CentreServiceSubSdRepository repository;
    public CenterServiceSubService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "locations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LocationSdListResponse getCentreServiceSubLocation(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getCentreServiceSubLocation";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<LocationSd> result = repository.getLocationByCentreService(Version.getVersion(version), languageList, centreServiceMUrl,centreServiceSUrl, hospitalCode);

        LocationSdListResponse response = new LocationSdListResponse(result);

        completed(methodName);
        return response;
    }
}
