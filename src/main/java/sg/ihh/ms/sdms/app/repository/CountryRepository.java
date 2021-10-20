package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Country;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class CountryRepository extends BaseRepository {

    public CountryRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "country");
        tableMap.put(Version.PUBLISHED.getKey(), "country");
    }

    public List<Country> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Country.class);
    }
}
