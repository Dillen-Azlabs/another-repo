package sg.ihh.ms.sdms.app.repository.model;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ChildSpecialty;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.BaseRepository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ChildSpecialtyRepository extends BaseRepository {
    public ChildSpecialtyRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "child_specialty");
        tableMap.put(Version.PUBLISHED.getKey(), "child_specialty");
    }
    public List<ChildSpecialty> list(Version version, List<String> languageList) {
        return super.list(version, languageList, ChildSpecialty.class);
    }

}
