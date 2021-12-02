package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sg.ihh.ms.sdms.app.model.MDStaffDemographic;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.MDStaffDemographicRepository;
import sg.ihh.ms.sdms.app.rest.model.MDStaffDemographicListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "mdstaff", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class MDStaffDemographicService extends BaseService{
    @Autowired
    private MDStaffDemographicRepository repository;

    public MDStaffDemographicService() {
        log = getLogger(this.getClass());
    }

    @GetMapping("demographics")
    public MDStaffDemographicListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version ){
        final String methodName = "list";
        start(methodName);


        List<MDStaffDemographic> list = repository.list(Version.getVersion(version));

        MDStaffDemographicListResponse response = new MDStaffDemographicListResponse(list);

        completed(methodName);
        return response;


    }
    @GetMapping("demographics/{ProviderId}")
    public MDStaffDemographic findById(@PathVariable String ProviderId){
        return repository.getDemographicProviderId(ProviderId);
    }



}
