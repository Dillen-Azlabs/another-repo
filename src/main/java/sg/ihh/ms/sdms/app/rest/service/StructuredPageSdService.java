package sg.ihh.ms.sdms.app.rest.service;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.repository.StructuredPageSdRepository;
import sg.ihh.ms.sdms.app.rest.model.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "structuredPage", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class StructuredPageSdService extends BaseService {

    @Autowired
    private StructuredPageSdRepository repository;

    public StructuredPageSdService() {
        log = getLogger(this.getClass());
    }

    //START - Structured Page Basic Detail Block
    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageBasicDetailListResponse getStructuredPageBasicDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getStructuredPageBasicDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredPageBasicDetail result = repository.getStructuredPageBasicDetail(Version.getVersion(version), languageList, structuredPageUrl, hospitalCode);

        StructuredPageBasicDetailListResponse response = new StructuredPageBasicDetailListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Basic Detail Block

    //START - Structured Page CTA  Block
    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageCtaListResponse getStructuredPageCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl) {
        final String methodName = "getStructuredPageCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredPageCta result = repository.getStructuredPageCta(Version.getVersion(version), languageList, structuredPageUrl);

        StructuredPageCtaListResponse response = new StructuredPageCtaListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page CTA  Block

    //START - Structured Page Body Section Block
    @RequestMapping(path = "bodySections", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageBodySectionListResponse getStructuredPageBodySection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl,
            @RequestParam("sectionNumber") @Range(min = 1, max = 3,
                    message = "Allowed Values : 1, 2, 3") int sectionNumber) {
        final String methodName = "getStructuredPageBodySection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredPageBodySection> result = repository.getStructuredPageBodySection(Version.getVersion(version), languageList, structuredPageUrl, sectionNumber);


        StructuredPageBodySectionListResponse response = new StructuredPageBodySectionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Body Section Block
}
