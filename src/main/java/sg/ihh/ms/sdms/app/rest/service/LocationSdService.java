package sg.ihh.ms.sdms.app.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.LocationSd;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.CentreServiceMainSdRepository;
import sg.ihh.ms.sdms.app.repository.LocationSdRepository;
import sg.ihh.ms.sdms.app.rest.model.LocationSdListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "locations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class LocationSdService extends  BaseService {
    @Autowired
    private LocationSdRepository repository;

    public LocationSdService(){
        log = getLogger(this.getClass());
    }

    @GetMapping
    public LocationSdListResponse getLocationByItemUrl(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("itemUrls") String itemUrl,
            @RequestParam("hospitalCode") String hospitalCode){
        final String methodName = "getLocationByItemUrl";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<LocationSd> result = repository.getLocationByItemUrl(Version.getVersion(version), languageList, itemUrl, hospitalCode);

        LocationSdListResponse response = new LocationSdListResponse(result);

        completed(methodName);
        return response;
    }
}
