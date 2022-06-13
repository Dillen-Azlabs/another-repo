package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.ChildSpecialty;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.List;

@Repository
public class ChildSpecialtyRepository extends BaseRepository {
    public ChildSpecialtyRepository() {
        log = getLogger(this.getClass());

        tableName = "child_specialty";
    }
    public List<ChildSpecialty> list(Version version, List<String> languageList) {
        return super.list(version, languageList, ChildSpecialty.class);
    }

}
