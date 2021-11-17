package sg.ihh.ms.sdms.app.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.Language;
import sg.ihh.ms.sdms.app.model.Version;

@Repository
public class LanguageRepository extends BaseRepository {

    public LanguageRepository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "language");
        tableMap.put(Version.PUBLISHED.getKey(), "language_ro");
    }

    public List<Language> list(Version version, List<String> languageList) {
        return super.list(version, languageList, Language.class);
    }
}
