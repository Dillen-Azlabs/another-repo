package sg.ihh.ms.sdms.app.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.StructuredCampaignDetails;
import sg.ihh.ms.sdms.app.model.StructuredPageBasicDetail;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.StructuredCampaignRepository;
import sg.ihh.ms.sdms.app.rest.model.StructuredCampaignResponse;
import sg.ihh.ms.sdms.app.rest.model.StructuredPageBasicDetailListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "structuredCampaign", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class StructuredCampaignService extends BaseService {

    @Autowired
    private StructuredCampaignRepository repository;

    public StructuredCampaignService() {
        log = getLogger(this.getClass());
    }

    //START - Structured Page Basic Detail Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredCampaignResponse getStructuredCampaignBasicDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredCampaignUrl") String structuredPageUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getStructuredCampaignBasicDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredCampaignDetails result = repository.getStructuredCampaignDetails(Version.getVersion(version), languageList, structuredPageUrl, hospitalCode);

        StructuredCampaignResponse response = new StructuredCampaignResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Basic Detail Block
}
