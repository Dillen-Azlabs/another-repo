package sg.ihh.ms.sdms.app.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.model.hPac;
import sg.ihh.ms.sdms.app.repository.hPacRepository;
import sg.ihh.ms.sdms.app.rest.model.PacListResponse;
import sg.ihh.ms.sdms.app.rest.model.hPacListResponse;


@RestController
@RequestMapping(path= "Hpac", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@Validated
public class hpacServices extends BaseService {

	@Autowired
	private hPacRepository repository;
		
	public hpacServices() {
		log = getLogger(this.getClass());
	}
	
	
	@RequestMapping(path = "Hcountry", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public hPacListResponse getPacByCountry( @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$", message = "Allowed Values : DRAFT, PUBLISHED") String version,
			@RequestParam Map<String, String> requestParams)
	
	
	{
		final String methodName = "getPacByCountry";
		start(methodName); //Start log
		
		List<hPac> result = new ArrayList<>();
		hPacListResponse hPacListResponse = new hPacListResponse(result);
		if(requestParams.containsKey("languageCode"))
		{
			String languageCode = requestParams.get("languageCode");
			List<String> languageList = getLanguageList(languageCode);
			
			        //Inner IF for searching by country
		        	//IF HAVE COUNTRY THEN CONTINUE(request country key from url)
			
					if(requestParams.containsKey("country"))
					{
						String country = requestParams.get("country");
		                result = repository.searchByCountry(Version.getVersion(version), languageList, country);
		
						if (country.isEmpty()) {
							result = repository.list(Version.getVersion(version), languageList); // return back PURE data
							
							hPacListResponse = new hPacListResponse(result);
							
							// PURE DATA(result) returned from DATABASE, ordered according to json:
							// (PACLIST_RESPONSE continue BASE_RESPONSE) IN JSON ORDER THEN ( PAC continue BASE_MODEL) IN JSON ORDER
							
							hPacListResponse.setCountry(null);
						}
					}
			else {
				result = repository.list(Version.getVersion(version), languageList); // return back PURE data
			}
			hPacListResponse = new hPacListResponse(result);
			
			// PURE DATA(result) returned from DATABASE, ordered according to json:
			// (PACLIST_RESPONSE continue BASE_RESPONSE) IN JSON ORDER THEN ( PAC + BASE_MODEL) IN JSON ORDER
			                // RESPONSE //                                     //MODEL JSON//
			
			String country = requestParams.get("country");
			hPacListResponse.setCountry(country);

		}
		
		completed(methodName);//end log
		return hPacListResponse; // return all the json
		
	}

}
