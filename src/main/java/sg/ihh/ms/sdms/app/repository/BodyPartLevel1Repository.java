package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.BodyPartLevel1;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.HashMap;
import java.util.List;


@Repository
public class BodyPartLevel1Repository extends BaseRepository{
    public BodyPartLevel1Repository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "body_part_level1");
        tableMap.put(Version.PUBLISHED.getKey(), "body_part_level1_ro");
    }
    public List<BodyPartLevel1> list(Version version, List<String> languageList) {
        return super.list(version, languageList, BodyPartLevel1.class);
    }

}
