package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ConditionDisease;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class ConditionDiseaseRepository extends BaseRepository {

    public ConditionDiseaseRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "condition_disease");
        tableMap.put(Version.PUBLISHED.getKey(), "condition_disease_ro");
    }

    public List<ConditionDisease> list(Version version, List<String> languageList) {
        return super.list(version, languageList, ConditionDisease.class);
    }
}
