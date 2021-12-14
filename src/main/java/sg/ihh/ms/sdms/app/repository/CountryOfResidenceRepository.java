package sg.ihh.ms.sdms.app.repository;


import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.CountryOfResidence;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.HashMap;
import java.util.List;

@Repository
public class CountryOfResidenceRepository extends BaseRepository {

    public CountryOfResidenceRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "country_of_residence");
        tableMap.put(Version.PUBLISHED.getKey(), "country_of_residence_ro");
    }
    public List<CountryOfResidence> list(Version version, List<String> languageList) {
        return super.list(version, languageList, CountryOfResidence.class);
    }
}
