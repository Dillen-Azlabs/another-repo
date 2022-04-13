package sg.ihh.ms.sdms.app.repository;

import java.util.List;

import sg.ihh.ms.sdms.app.model.Gender;
import sg.ihh.ms.sdms.app.model.HresidenceCountry;
import sg.ihh.ms.sdms.app.model.Version;

public class HresidenceCountryRepository extends BaseRepository {

	
	public HresidenceCountryRepository()
	{
        log = getLogger(this.getClass());
        tableName = "country_residence";
        
	}
	 public List<HresidenceCountry> list(Version version, List<String> languageList) {
	        return super.list(version, languageList, HresidenceCountry.class);
	    }
	
	
}