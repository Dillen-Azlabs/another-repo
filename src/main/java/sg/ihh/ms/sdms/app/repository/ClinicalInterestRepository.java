package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ClinicalInterest;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.HashMap;
import java.util.List;

@Repository
public class ClinicalInterestRepository extends BaseRepository{
    public ClinicalInterestRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "clinical_interest");
        tableMap.put(Version.PUBLISHED.getKey(), "clinical_interest_ro");
    }
    public List<ClinicalInterest> list(Version version, List<String> languageList) {
        return super.list(version, languageList, ClinicalInterest.class);
    }

}
