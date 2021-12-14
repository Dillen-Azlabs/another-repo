package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Nationality;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.HashMap;
import java.util.List;

@Repository
public class NationalityRepository extends BaseRepository{
    public NationalityRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "nationality");
        tableMap.put(Version.PUBLISHED.getKey(), "nationality_ro");
    }
    public List<Nationality> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Nationality.class);
    }

}
