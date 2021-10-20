package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ServiceProvider;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class ServiceProviderRepository extends BaseRepository {

    public ServiceProviderRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "service_provider_type");
        tableMap.put(Version.PUBLISHED.getKey(), "service_provider_type");
    }

    public List<ServiceProvider> list(Version version, List<String> languageList) {
        return super.list(version, languageList, ServiceProvider.class);
    }
}
