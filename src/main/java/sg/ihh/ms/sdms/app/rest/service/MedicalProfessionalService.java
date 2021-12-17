package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.MedicalProfessionalRepository;
import sg.ihh.ms.sdms.app.repository.PacRepository;
import sg.ihh.ms.sdms.app.rest.model.*;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "medicalProfessionals", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class MedicalProfessionalService extends BaseService {

    @Autowired
    private PacRepository pacRepository;

    @Autowired
    private MedicalProfessionalRepository mpRepository;

    @Autowired
    private StructuredDataProcessor<Pac> pacProcessor;

    @Autowired
    private StructuredDataProcessor<MedicalProfessionalBasic> mpbProcessor;

    @Autowired
    private StructuredDataProcessor<MedicalProfessionalDetail> mpdProcessor;

    @Autowired
    private StructuredDataProcessor<Portfolio> mppProcessor;

    @Autowired
    private StructuredDataProcessor<MediaCoverage> mcProcessor;

    @Autowired
    private StructuredDataProcessor<Testimonial> tProcessor;

    @Autowired
    private StructuredDataProcessor<Clinic> cProcessor;

    public MedicalProfessionalService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public MedicalProfessionalBasicListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<MedicalProfessionalBasic> result = mpRepository.list(Version.getVersion(version), languageList);

        result = mpbProcessor.processList(result, languageCode);

        MedicalProfessionalBasicListResponse response = new MedicalProfessionalBasicListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "details", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public MedicalProfessionalDetailListResponse getMedicalProfessionalDetails(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("medicalProfessionalUrl") String medicalProfessionalUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getMedicalProfessionalDetails";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<MedicalProfessionalDetail> result = mpRepository.getDetails(Version.getVersion(version), languageList, medicalProfessionalUrl, hospitalCode);

        result = mpdProcessor.processList(result, languageCode);

        MedicalProfessionalDetailListResponse response = new MedicalProfessionalDetailListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "portfolio", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PortfolioListResponse getMedicalProfessionalPortfolio(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("medicalProfessionalUrl") String medicalProfessionalUrl,
            @RequestParam("country") String country) {
        final String methodName = "getMedicalProfessionalPortfolio";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Portfolio> result = mpRepository.getPortfolio(Version.getVersion(version), languageList, medicalProfessionalUrl, country);

        result = mppProcessor.processList(result, languageCode);

        PortfolioListResponse response = new PortfolioListResponse(result);

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "clinics", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ClinicListResponse getMedicalProfessionalClinics(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("medicalProfessionalUrl") String medicalProfessionalUrl) {
        final String methodName = "getMedicalProfessionalClinics";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Clinic> result = mpRepository.getClinics(Version.getVersion(version), languageList, medicalProfessionalUrl);

        result = cProcessor.processList(result, languageCode);

        ClinicListResponse response = new ClinicListResponse(result);

        response.setDisplayName(mpRepository.getDisplayName(Version.getVersion(version), languageList, medicalProfessionalUrl));

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "testimonials", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TestimonialListResponse getMedicalProfessionalTestimonials(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("medicalProfessionalUrl") String medicalProfessionalUrl,
            @RequestParam("country") String country,
            @RequestParam("itemCount") Optional<Integer> itemCount) {
        final String methodName = "getMedicalProfessionalTestimonials";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Testimonial> result = mpRepository.getTestimonials(Version.getVersion(version), languageList, medicalProfessionalUrl, country);

        result = tProcessor.processList(result, languageCode);

        // set to big number if request param is not present
        int count = itemCount.isPresent() ? itemCount.get() : 255;

        count = result.size() < count ? result.size() : count;

        List<Testimonial> resultResponse = result.subList(0, count);

        TestimonialListResponse response = new TestimonialListResponse(resultResponse);

        response.setDisplayName(mpRepository.getDisplayName(Version.getVersion(version), languageList, medicalProfessionalUrl));

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "mediaCoverage", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public MediaCoverageListResponse getMedicalProfessionalMediaCoverage(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("medicalProfessionalUrl") String medicalProfessionalUrl,
            @RequestParam("mediaCoverageLanguage") String mediaCoverageLanguage) {
        final String methodName = "getMedicalProfessionalMediaCoverages";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<MediaCoverage> result = mpRepository.getMediaCoverage(Version.getVersion(version), languageList, medicalProfessionalUrl, mediaCoverageLanguage);

        result = mcProcessor.processList(result, languageCode);

        MediaCoverageListResponse response = new MediaCoverageListResponse(result);

        response.setDisplayName(mpRepository.getDisplayName(Version.getVersion(version), languageList, medicalProfessionalUrl));

        completed(methodName);
        return response;
    }

    @RequestMapping(path = "pac", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PacListResponse getPacByMedicalProfessional(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("medicalProfessionalUrl") String medicalProfessionalUrl,
            @RequestParam("excludeCountry") String excludeCountry) {

        final String methodName = "getPacByMedicalProfessional";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<Pac> result = pacRepository.searchPacByItemUrl(Version.getVersion(version), languageList, medicalProfessionalUrl, excludeCountry);

        result = pacProcessor.processList(result, languageCode);

        PacListResponse response = new PacListResponse(result);

        response.setDisplayName(mpRepository.getDisplayName(Version.getVersion(version), languageList, medicalProfessionalUrl));

        completed(methodName);
        return response;
    }
}
