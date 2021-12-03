package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sg.ihh.ms.sdms.app.model.MDStaffDemographic;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.MDStaffDemographicRepository;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;
import sg.ihh.ms.sdms.app.rest.model.MDStaffDemographicListResponse;
import sg.ihh.ms.sdms.app.rest.model.request.MDStaffDemographicRequest;
import sg.ihh.ms.sdms.app.rest.validator.MDStaffDemographicValidator;
import sg.ihh.ms.sdms.app.util.json.JsonUtil;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "mdstaff", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class MDStaffDemographicService extends BaseService{
    @Autowired
    private MDStaffDemographicRepository repository ;

    private MDStaffDemographicValidator validator ;

    public MDStaffDemographicService() {

        log = getLogger(this.getClass());
        validator = new MDStaffDemographicValidator();
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
    public MDStaffDemographic findById(@PathVariable String ProviderId)
    {
        if(repository.validateMDStaffDemographic(ProviderId))
        {
             return repository.getDemographicProviderId(ProviderId);

        }
        return null;
    }

    @PutMapping(value ="demographics/{ProviderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse update(@PathVariable String ProviderId, @RequestBody MDStaffDemographicRequest mdStaffDemographicRequest){
        BaseResponse response = buildErrorResponse();
        mdStaffDemographicRequest.setProviderId(UUID.randomUUID().toString());
        if(validator.validate(mdStaffDemographicRequest) && repository.validateMDStaffDemographic(ProviderId)){
            if(repository.updateMDStaffDemographic(ProviderId ,mdStaffDemographicRequest))
            {
                response = buildSuccessResponse();
            }
        }
        return response;
    }

    @DeleteMapping("demographics/{ProviderId}")
    public BaseResponse deleteById(@PathVariable String ProviderId){
        BaseResponse response = buildErrorResponse();
        if(repository.validateMDStaffDemographic(ProviderId))
        {
            if(repository.delete(ProviderId)) {
                response = buildSuccessResponse();
            }
        }
        return response;
    }

    @PostMapping(value = "demographics", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse add(@RequestBody MDStaffDemographicRequest mdStaffDemographicRequest)
    {
        BaseResponse response = buildErrorResponse();
        if(validator.validate(mdStaffDemographicRequest))
        {
            mdStaffDemographicRequest.setProviderId(UUID.randomUUID().toString());
            if(repository.addMDStaffDemographic(mdStaffDemographicRequest))
            {
                response = buildSuccessResponse();
            }
        }
         return response;
    }

    }
