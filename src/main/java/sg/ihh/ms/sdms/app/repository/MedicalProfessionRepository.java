package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.MedicalProfession;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class MedicalProfessionRepository extends BaseRepository {

    public MedicalProfessionRepository() {
        log = getLogger(getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "medical_profession_type");
        tableMap.put(Version.PUBLISHED.getKey(), "medical_profession_type");
    }

    public List<MedicalProfession> list(Version version, List<String> languageList) {
        return super.list(version, languageList, MedicalProfession.class);
    }
}
