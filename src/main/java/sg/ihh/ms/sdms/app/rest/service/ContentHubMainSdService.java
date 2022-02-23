package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.ContentHubMainAward;
import sg.ihh.ms.sdms.app.model.ContentHubMainBasicDetail;
import sg.ihh.ms.sdms.app.model.ContentHubMainCta;
import sg.ihh.ms.sdms.app.model.ContentHubMainBodySection;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.ContentHubMainSdRepository;
import sg.ihh.ms.sdms.app.rest.model.ContentHubMainAwardListResponse;
import sg.ihh.ms.sdms.app.rest.model.ContentHubMainBasicDetailListResponse;


import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "contentHubM", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ContentHubMainSdService extends BaseService{

    @Autowired
    private ContentHubMainSdRepository repository;

    @Autowired
    private StructuredDataProcessor<ContentHubMainBasicDetail> bdprocessor;


    public ContentHubMainSdService() {
        log = getLogger(this.getClass());
    }

    //START - Content Hub Main Basic Detail Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainBasicDetailListResponse getContentHubMBasicDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("contentHubMUrl") String contentHubMUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getContentHubMBasicDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        ContentHubMainBasicDetail result = repository.getContentHubMainBasicDetail(Version.getVersion(version), languageList, contentHubMUrl,hospitalCode);

        ContentHubMainBasicDetailListResponse response = new ContentHubMainBasicDetailListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Content Hub Main Basic Detail Block

    //START - Content Hub Main Award Block
    @RequestMapping(path = "award", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ContentHubMainAwardListResponse getAward(@RequestParam("version")@Pattern(regexp = "^(DRAFT|PUBLISHED)$",
            message = "Allowed Values : DRAFT, PUBLISHED") String version, @RequestParam Map<String, String> requestParams) {
        final String methodName = "getAward";
        start(methodName);
        List<ContentHubMainAward> result = new ArrayList<>();
        ContentHubMainAwardListResponse contentHubMainAwardListResponse = new ContentHubMainAwardListResponse(result);

        if (requestParams.containsKey("languageCode") && requestParams.containsKey("contentHubMUrl") && requestParams.containsKey("hospitalCode")&& requestParams.containsKey("country")) {
            String languageCode = requestParams.get("languageCode");
            String contentHubMUrl = requestParams.get("contentHubMUrl");
            String hospitalCode = requestParams.get("hospitalCode");
            String country = requestParams.get("country");
            List<String> languageList = getLanguageList(languageCode);

            if (hospitalCode.equals("ALL")) {

                result = repository.list(Version.getVersion(version), languageList, contentHubMUrl,country);
                contentHubMainAwardListResponse = new ContentHubMainAwardListResponse(result);
                return  contentHubMainAwardListResponse;

            } else {
                result = repository.getContentHubMainAward(Version.getVersion(version), languageList, contentHubMUrl, hospitalCode, country);
            }
            contentHubMainAwardListResponse = new ContentHubMainAwardListResponse(result);

        }
        completed(methodName);
        return contentHubMainAwardListResponse;
    }

    //END - Content Hub Main Award Block



}
