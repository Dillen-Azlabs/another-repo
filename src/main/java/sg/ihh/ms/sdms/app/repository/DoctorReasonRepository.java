package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.DoctorReason;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class DoctorReasonRepository extends BaseRepository {

    public DoctorReasonRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "doctor_reason");
        tableMap.put(Version.PUBLISHED.getKey(), "doctor_reason_ro");
    }

    public List<DoctorReason> list(Version version, List<String> languageList) {
        return super.list(version, languageList, DoctorReason.class);
    }
}
