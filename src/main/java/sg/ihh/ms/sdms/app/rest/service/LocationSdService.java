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
            @RequestParam("itemUrls") List<String> itemUrl){
        final String methodName = "getLocationByItemUrl";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<LocationSd> result = repository.getLocationByItemUrl(Version.getVersion(version), languageList, itemUrl);

        LocationSdListResponse response = new LocationSdListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "centreServices", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LocationSdListResponse getLocationByCentreService(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("centreServiceMUrl") String centreServiceMUrl,
            @RequestParam("centreServiceSUrl") String centreServiceSUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getLocationByCentreService";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);


        List<LocationSd> result = repository.getLocationByCentreService(Version.getVersion(version), languageList, centreServiceMUrl,centreServiceSUrl, hospitalCode);

        LocationSdListResponse response = new LocationSdListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "search", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LocationSdListResponse getLocationByHospital(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("hospitalCodes") List<String> hospital,
            @RequestParam("locationTypes") List<String> locationType){
        final String methodName = "getLocationByHospital";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        if (locationType.isEmpty()) {
            locationType.add("Hospital");
            locationType.add("Pharmacy");
            locationType.add("F&B");
            locationType.add("Accident and Emergency");
            locationType.add("Medical facility or centre");
            locationType.add("Retail shops");
        }

        List<LocationSd> result = repository.getLocationByHospitalAndLocation(Version.getVersion(version), languageList, hospital,locationType);

        LocationSdListResponse response = new LocationSdListResponse(result);

        completed(methodName);
        return response;
    }
}
