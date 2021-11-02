package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Specialty;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class SpecialtyRepository extends BaseRepository {

    public SpecialtyRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "specialty");
        tableMap.put(Version.PUBLISHED.getKey(), "specialty_ro");
    }

    public List<Specialty> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Specialty.class);
    }
}
