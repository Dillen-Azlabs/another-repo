package sg.ihh.ms.sdms.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.ihh.ms.sdms.app.model.CountryOfResidence;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class HCORRepository extends BaseRepository {

    public HCORRepository() {
        log = getLogger(this.getClass());
        tableName = "country_of_residence";
    }

    public List<CountryOfResidence> list(Version version, List<String> languageList) {
        return super.list(version, languageList, CountryOfResidence.class);
    }
}
