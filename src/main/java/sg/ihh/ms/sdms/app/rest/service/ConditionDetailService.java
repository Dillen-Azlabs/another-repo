package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.ihh.ms.sdms.app.model.ConditionDetail;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.processor.StructuredDataProcessor;
import sg.ihh.ms.sdms.app.repository.ConditionDetailRepository;
import sg.ihh.ms.sdms.app.rest.model.ConditionDetailListResponse;


import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "conditions1", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class ConditionDetailService extends BaseService{
    @Autowired
    private ConditionDetailRepository repository;


    @Autowired
    private StructuredDataProcessor<ConditionDetail> cdProcessor;

    public ConditionDetailService() {
        log = getLogger(this.getClass());
    }




}
