package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.TestTreatment;
import sg.ihh.ms.sdms.app.model.Treatment;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.TestTreatmentRepository;
import sg.ihh.ms.sdms.app.repository.TreatmentRepository;
import sg.ihh.ms.sdms.app.rest.model.TestTreatmentListResponse;
import sg.ihh.ms.sdms.app.rest.model.TreatmentListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "testTreatments", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class TestTreatmentService extends BaseService {

    @Autowired
    private TestTreatmentRepository repository;

    @Autowired
    private ControlledListProcessor<TestTreatment> processor;

    public TestTreatmentService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public TestTreatmentListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<TestTreatment> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        TestTreatmentListResponse response = new TestTreatmentListResponse(list);

        completed(methodName);
        return response;
    }
}
