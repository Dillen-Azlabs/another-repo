package sg.ihh.ms.sdms.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.Gender;
import sg.ihh.ms.sdms.app.model.HresidenceCountry;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class HresidenceCountryRepository extends BaseRepository {

	
	public HresidenceCountryRepository()
	{
        log = getLogger(this.getClass());
        tableName = "country_of_residence";
        
	}
	 public List<HresidenceCountry> list(Version version, List<String> languageList) {
	        return super.list(version, languageList, HresidenceCountry.class);
	    }

}
