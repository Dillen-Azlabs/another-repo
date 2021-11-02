package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Gender;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class GenderRepository extends BaseRepository {

    public GenderRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "gender");
        tableMap.put(Version.PUBLISHED.getKey(), "gender_ro");
    }

    public List<Gender> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Gender.class);
    }
}
