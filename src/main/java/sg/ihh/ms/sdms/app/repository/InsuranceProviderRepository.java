package sg.ihh.ms.sdms.app.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.InsuranceProvider;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class InsuranceProviderRepository extends BaseRepository {

    public InsuranceProviderRepository() {
        log = getLogger(this.getClass());

        tableName = "insurance_panel";
    }

    public List<InsuranceProvider> list(Version version, List<String> languageList) {
        return super.list(version, languageList, InsuranceProvider.class);
    }
}
