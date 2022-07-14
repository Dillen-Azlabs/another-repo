package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sg.ihh.ms.sdms.app.model.*;
import sg.ihh.ms.sdms.app.repository.MDStaffRepository;
import sg.ihh.ms.sdms.app.repository.model.Pagination;
import sg.ihh.ms.sdms.app.repository.model.Sort;
import sg.ihh.ms.sdms.app.rest.model.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "mdstaff", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class MDStaffProviderService extends BaseService {

    @Autowired
    private MDStaffRepository mdStaffRepository;

    public MDStaffProviderService() {
        log = getLogger(this.getClass());
    }

    @PostMapping("providers/search")
    public MDStaffProviderListResponse search(@RequestBody @Valid MDStaffProviderSearchRequest request) {
        final String methodName = "search";
        start(methodName);
        logRequest(methodName, request);

        List<Sort> sortList = request.getOrderList().stream()
                .map(order -> new Sort(order.getField(), order.getModifier())).collect(Collectors.toList());

        List<MDStaffProvider> list =
                mdStaffRepository.search(request.getSearchTerm(), sortList, new Pagination(request.getOffset(), request.getPageSize()));

        MDStaffProviderListResponse response = new MDStaffProviderListResponse(list);
        completed(methodName);
        return response;
    }

    @RequestMapping(path = "providers/address", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public MDStaffProviderAddressListResponse getProviderAddress(@RequestParam("mcrNumber") String mcrNumber) {
        final String methodName = "getProviderAddress";
        start(methodName);

        List<MDStaffSite> result = mdStaffRepository.getProviderClinics(mcrNumber);

        MDStaffProviderAddressListResponse response = new MDStaffProviderAddressListResponse(result);

        response.setMcrNumber(mcrNumber);

        completed(methodName);
        return response;
    }
    
    @RequestMapping(path = "providers/appointment", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public MDStaffProviderAppointmentListResponse getProviderAppointment(@RequestParam("mcrNumber") String mcrNumber) {
        final String methodName = "getProviderAppointment";
        start(methodName);

        List<MDStaffProviderAppointment> result = mdStaffRepository.getProviderAppointment(mcrNumber);
        MDStaffProviderAppointmentListResponse response = new MDStaffProviderAppointmentListResponse(result);
        response.setMcrNumber(mcrNumber);

        completed(methodName);
        return response;
    }

}
