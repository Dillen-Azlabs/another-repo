package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Treatment;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class TreatmentRepository extends BaseRepository {

    public TreatmentRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "associated_treatment");
        tableMap.put(Version.PUBLISHED.getKey(), "associated_treatment_ro");
    }

    public List<Treatment> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Treatment.class);
    }
}
