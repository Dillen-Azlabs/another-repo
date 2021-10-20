package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.InsuranceProvider;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class InsuranceProviderRepository extends BaseRepository {

    public InsuranceProviderRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "insurance_provider");
        tableMap.put(Version.PUBLISHED.getKey(), "insurance_provider");
    }

    public List<InsuranceProvider> list(Version version, List<String> languageList) {
        return super.list(version, languageList, InsuranceProvider.class);
    }
}
