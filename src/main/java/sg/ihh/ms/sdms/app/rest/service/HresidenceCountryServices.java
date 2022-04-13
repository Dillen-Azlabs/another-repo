package sg.ihh.ms.sdms.app.rest.service;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.ihh.ms.sdms.app.model.Gender;
import sg.ihh.ms.sdms.app.model.HresidenceCountry;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.processor.ControlledListProcessor;
import sg.ihh.ms.sdms.app.repository.HresidenceCountryRepository;
import sg.ihh.ms.sdms.app.rest.model.GenderListResponse;
import sg.ihh.ms.sdms.app.rest.model.HresidenceCountryListResponse;

@RestController
@RequestMapping(path="hcountriesOfResidence",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class HresidenceCountryServices extends BaseService {

	
	@Autowired
	private HresidenceCountryRepository repository;
	
	@Autowired
	private ControlledListProcessor<HresidenceCountry> processor;
	
	public HresidenceCountryServices()
	{
		log = getLogger(this.getClass());
	}
	
	
	
	
	@GetMapping
    public HresidenceCountryListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language 
        List<String> languageList = getLanguageList(languageCode);
        
        List<HresidenceCountry> list = repository.list(Version.getVersion(version), languageList);

        list = processor.processList(list, languageCode);
        
        HresidenceCountryListResponse response = new HresidenceCountryListResponse(list);
//
//        completed(methodName);        return response;
        
		return null;

	}
}
