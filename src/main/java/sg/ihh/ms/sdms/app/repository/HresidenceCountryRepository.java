package sg.ihh.ms.sdms.app.repository;

public class HresidenceCountryRepository extends BaseRepository {

	
	public HresidenceCountryRepository()
	{
        log = getLogger(this.getClass());
        tableName = "country_residence";
        
        
	}
	
}
