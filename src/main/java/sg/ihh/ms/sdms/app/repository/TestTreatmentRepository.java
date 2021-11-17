package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.TestTreatment;
import sg.ihh.ms.sdms.app.model.Treatment;
import sg.ihh.ms.sdms.app.model.Version;

import java.util.HashMap;
import java.util.List;

@Repository
public class TestTreatmentRepository extends BaseRepository {

    public TestTreatmentRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "test_treatment");
        tableMap.put(Version.PUBLISHED.getKey(), "test_treatment_ro");
    }

    public List<TestTreatment> list(Version version, List<String> languageList) {
        return super.list(version, languageList, TestTreatment.class);
    }
}
