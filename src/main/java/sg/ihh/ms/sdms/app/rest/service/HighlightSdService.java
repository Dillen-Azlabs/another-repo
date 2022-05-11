package sg.ihh.ms.sdms.app.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.HighlightsSearch;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.HighlightSdRepository;
import sg.ihh.ms.sdms.app.rest.model.HighlightsSearchResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "mh360", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class HighlightSdService extends  BaseService {

    @Autowired
    private HighlightSdRepository repository;

    public HighlightSdService() {
        log = getLogger(this.getClass());
    }

    //START - Highlight Search Block
    @RequestMapping(path = "highlights", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public HighlightsSearchResponse getHighlightSearch(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("publishDateFrom") String publishDateFrom,
            @RequestParam("publishDateTo") String publishDateTo) {
        final String methodName = "getHighlightSearch";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<HighlightsSearch> result = repository.getHighlightSearch(Version.getVersion(version), languageList, publishDateFrom, publishDateTo);

        HighlightsSearchResponse response = new HighlightsSearchResponse(result);

        completed(methodName);
        return response;
    }
    //END - Highlight Search Block
}
