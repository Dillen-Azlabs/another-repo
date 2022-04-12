package sg.ihh.ms.sdms.app.rest.service;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="hcountriesOfResidence",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class HresidenceCountryServices extends BaseService {

	
	
	public HresidenceCountryServices()
	{
		log = getLogger(this.getClass());
	}
}
