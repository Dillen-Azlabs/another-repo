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

import sg.ihh.ms.sdms.app.model.CountryOfResidence;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.HCORRepository;
import sg.ihh.ms.sdms.app.rest.model.HCORListResponse;

@RestController
@RequestMapping(path = "/HcountriesOfResidence", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class HCORService extends BaseService {

    private final HCORRepository hcorRepository;

    @Autowired
    public HCORService(HCORRepository hcorRepository) {
        this.hcorRepository = hcorRepository;
    }

//    @GetMapping("/sdms/api/HcountriesOfResidence")
    @GetMapping
    public HCORListResponse getHcountriesOfResidence(
            @RequestParam("languageCode")
            @NotBlank
            String languageCode,
            @RequestParam("version")
            @NotBlank
            @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED")
            String version
    ) {
        String logMethodName = "getHcountriesOfResidence";
        start(logMethodName);

//        if (!(version.equals("DRAFT") || version.equals("PUBLISHED"))) {
//            throw new IllegalStateException("Invalid version");
//        }

        List<CountryOfResidence> CORList = hcorRepository.list(Version.getVersion(version), getLanguageList(languageCode));
        // Processor.process ?? SQL query already queries with language code

        HCORListResponse response = new HCORListResponse(CORList);
        completed(logMethodName);
        return response;
    }
}
