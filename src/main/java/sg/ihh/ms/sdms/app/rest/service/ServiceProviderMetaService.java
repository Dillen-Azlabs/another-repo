package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.ServiceProviderMeta;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.ServiceProviderMetaRepository;
import sg.ihh.ms.sdms.app.rest.model.ServiceProviderMetaListResponse;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@RestController
@RequestMapping(path = "serviceProvidersMeta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated

public class ServiceProviderMetaService extends BaseService{
    @Autowired
    private ServiceProviderMetaRepository repository;

    @Autowired
    private ControlledListProcessor<ServiceProviderMeta> processor;

    public ServiceProviderMetaService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public ServiceProviderMetaListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") @NotNull String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        List<ServiceProviderMeta> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);

        ServiceProviderMetaListResponse response = new ServiceProviderMetaListResponse(list);

        completed(methodName);
        return response;
    }

}
