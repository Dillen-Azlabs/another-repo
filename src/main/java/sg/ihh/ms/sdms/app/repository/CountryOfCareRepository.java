package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.CountryOfCare;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.List;


@Repository
public class CountryOfCareRepository extends BaseRepository {

    public CountryOfCareRepository() {
        log = getLogger(this.getClass());

        tableName = "country_of_care";
    }
    public List<CountryOfCare> list(Version version, List<String> languageList) {
        return super.list(version, languageList, CountryOfCare.class);
    }
}
