package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ClinicInterest;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.HashMap;
import java.util.List;

@Repository
public class ClinicInterestRepository extends BaseRepository{
    public ClinicInterestRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "clinic_interest");
        tableMap.put(Version.PUBLISHED.getKey(), "clinic_interest_ro");
    }
    public List<ClinicInterest> list(Version version, List<String> languageList) {
        return super.list(version, languageList, ClinicInterest.class);
    }

}
