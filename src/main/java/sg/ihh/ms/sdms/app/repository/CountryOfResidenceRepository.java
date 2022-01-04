package sg.ihh.ms.sdms.app.repository;


import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.CountryOfResidence;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.List;

@Repository
public class CountryOfResidenceRepository extends BaseRepository {

    public CountryOfResidenceRepository() {
        log = getLogger(this.getClass());

        tableName = "country_of_residence";
    }
    public List<CountryOfResidence> list(Version version, List<String> languageList) {
        return super.list(version, languageList, CountryOfResidence.class);
    }
}
