package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.SpecialtySdRepository;
import sg.ihh.ms.sdms.app.rest.model.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "specialties", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class SpecialtySdService extends BaseService{
    @Autowired
    private SpecialtySdRepository repository;

    @Autowired
    private StructuredDataProcessor<SpecialtyDetail> sdProcessor;

    @Autowired
    private StructuredDataProcessor<SpecialtyCta> scProcessor;

    public SpecialtySdService() {
        log = getLogger(this.getClass());
    }

    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyDetailListResponse getSpecialtyDetail(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getSpecialtyDetail";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<SpecialtyDetail> result = repository.getSpecialtyDetail(Version.getVersion(version), languageList, specialtyUrl,hospitalCode);

        result = sdProcessor.processList(result, languageCode);

        SpecialtyDetailListResponse response = new SpecialtyDetailListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "cta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SpecialtyCtaListResponse getSpecialtyCta(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("specialtyUrl") String specialtyUrl) {
        final String methodName = "getSpecialtyCta";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<SpecialtyCta> result = repository.getSpecialtyCta(Version.getVersion(version), languageList, specialtyUrl);

        result = scProcessor.processList(result, languageCode);

        SpecialtyCtaListResponse response = new SpecialtyCtaListResponse(result);

        completed(methodName);
        return response;
    }


}
