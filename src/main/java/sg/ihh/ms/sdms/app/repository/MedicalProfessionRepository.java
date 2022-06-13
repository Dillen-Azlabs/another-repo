package sg.ihh.ms.sdms.app.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.MedicalProfession;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class MedicalProfessionRepository extends BaseRepository {

    public MedicalProfessionRepository() {
        log = getLogger(getClass());

        tableName = "medical_professional_type";
    }

    public List<MedicalProfession> list(Version version, List<String> languageList) {
        return super.list(version, languageList, MedicalProfession.class);
    }
}
