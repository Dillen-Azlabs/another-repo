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

    //START - Structured Page Award Block
    @RequestMapping(path = "award", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageAwardListResponse getAward(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl,
            @RequestParam("sectionNumber") @Range(min = 1, max = 3,
                    message = "Allowed Values : 1, 2, 3") int sectionNumber,
            @RequestParam("country") String country,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getAward";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredPageAward> result = repository.getStructuredPageAward(Version.getVersion(version), languageList, structuredPageUrl,sectionNumber, hospitalCode, country);


        StructuredPageAwardListResponse response = new StructuredPageAwardListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Award Block

    //START - Structured Page Why Choose Us Block
    @RequestMapping(path = "whyChooseUs", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageWhyChooseUsListResponse getStructuredPageWcu(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl,
            @RequestParam("hospitalCode") String hospitalCode){
        final String methodName = "getStructuredPageWcu";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredPageWhyChooseUs> result = repository.getStructuredPageWcu(Version.getVersion(version), languageList, structuredPageUrl, hospitalCode);

        StructuredPageWhyChooseUsListResponse response = new StructuredPageWhyChooseUsListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Why Choose Us Block

    //START - Structured Page Card Carousel Block
    @RequestMapping(path = "card", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageCardCarouselListResponse getStructuredPageCardCarousel(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl){
        final String methodName = "getStructuredPageCardCarousel";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredPageCardCarousel result = repository.getStructuredPageCardCarousel(Version.getVersion(version), languageList, structuredPageUrl);

        StructuredPageCardCarouselListResponse response = new StructuredPageCardCarouselListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Card Carousel Block

    //START - Structured Page Faq Block
    @RequestMapping(path = "faq", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageFaqListResponse getStructuredPageFaq(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl){
        final String methodName = "getStructuredPageFaq";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredPageFaq> result = repository.getStructuredPageFaq(Version.getVersion(version), languageList, structuredPageUrl);

        StructuredPageFaqListResponse response = new StructuredPageFaqListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Faq Block

    //START - Structured Page Photo Gallery Block
    @RequestMapping(path = "photoGallery", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPagePhotoGalleryListResponse getStructuredPagePhotoGallery(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl){
        final String methodName = "getStructuredPagePhotoGallery";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredPagePhotoGallery result = repository.getStructuredPagePhotoGallery(Version.getVersion(version), languageList, structuredPageUrl);

        StructuredPagePhotoGalleryListResponse response = new StructuredPagePhotoGalleryListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Photo Gallery Block

    //START - Structured Page CTA Section Block
    @RequestMapping(path = "ctaSection", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageCtaSectionListResponse getStructuredPageCtaSection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl,
            @RequestParam("hospitalCode") String hospitalCode,
            @RequestParam("sectionNumber")@Range(min = 1, max = 3,
                    message = "Allowed Values : 1, 2") int sectionNumber) {
        final String methodName = "getStructuredPageCtaSection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredPageCtaSection result = repository.getStructuredPageCtaSection(Version.getVersion(version), languageList, structuredPageUrl,hospitalCode, sectionNumber);

        StructuredPageCtaSectionListResponse response = new StructuredPageCtaSectionListResponse(result);

        completed(methodName);
        return response;


    }
    //END - Structured Page CTA Section Block

    //START - Structured Page Accordion Block
    @RequestMapping(path = "accordion", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageAccordionListResponse getStructuredPageAccordion(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl){
        final String methodName = "getStructuredPageAccordion";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<StructuredPageAccordion> result = repository.getStructuredPageAccordion(Version.getVersion(version), languageList, structuredPageUrl);

        StructuredPageAccordionListResponse response = new StructuredPageAccordionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Accordion Block

    //START - Structured Page Media Section Block
    @RequestMapping(path = "mediaSection", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageMediaSectionListResponse getStructuredPageMediaSection(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl){
        final String methodName = "getStructuredPageMediaSection";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredPageMediaSection result = repository.getStructuredPageMediaSection(Version.getVersion(version), languageList, structuredPageUrl);

        StructuredPageMediaSectionListResponse response = new StructuredPageMediaSectionListResponse(result);

        completed(methodName);
        return response;
    }
    //END - Structured Page Media Section Block

    //START - Structured Page Tab Block
    @RequestMapping(path = "tab", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StructuredPageTabListResponse getStructuredPageTab(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode,
            @RequestParam("structuredPageUrl") String structuredPageUrl,
            @RequestParam("hospitalCode") String hospitalCode) {
        final String methodName = "getStructuredPageTab";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        StructuredPageTab result = repository.getStructuredPageTab(Version.getVersion(version), languageList, structuredPageUrl, hospitalCode);

        StructuredPageTabListResponse response = new StructuredPageTabListResponse(result);

        completed(methodName);
        return response;

    }
    //END - Structured Page Tab Block
}
