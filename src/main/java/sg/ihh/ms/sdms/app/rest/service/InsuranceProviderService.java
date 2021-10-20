package sg.ihh.ms.sdms.app.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.InsuranceProvider;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.InsuranceProviderRepository;
import sg.ihh.ms.sdms.app.rest.model.InsuranceProviderListResponse;

@RestController
@RequestMapping(path = "insuranceProviders",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class InsuranceProviderService extends BaseService {

    @Autowired
    private InsuranceProviderRepository repository;

    @Autowired
    private ControlledListProcessor<InsuranceProvider> processor;

    public InsuranceProviderService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public InsuranceProviderListResponse list(@RequestHeader("Accept-Version") String versionHeader,
            @RequestParam("languageCode") String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Version
        Version version = Version.getVersion(versionHeader);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<InsuranceProvider> list = repository.list(version, languageList);

        list = processor.processList(list, languageCode);

        InsuranceProviderListResponse response = new InsuranceProviderListResponse(list);

        completed(methodName);
        return response;
    }
}
