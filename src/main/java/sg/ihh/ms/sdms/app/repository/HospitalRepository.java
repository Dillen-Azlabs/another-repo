package sg.ihh.ms.sdms.app.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Hospital;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class HospitalRepository extends BaseRepository {

    public HospitalRepository() {
        log = getLogger(this.getClass());

        tableName = "hospital";
    }

    public List<Hospital> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Hospital.class);
    }
}
