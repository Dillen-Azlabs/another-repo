package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.ihh.ms.sdms.app.model.LocationSd;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.CentreServiceSubSdRepository;
import sg.ihh.ms.sdms.app.rest.model.LocationSdListResponse;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "centreServiceS", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class CentreServiceSubService extends BaseService{
    @Autowired
    private CentreServiceSubSdRepository repository;
    public CentreServiceSubService() {
        log = getLogger(this.getClass());
    }

}
