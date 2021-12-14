package sg.ihh.ms.sdms.app.repository;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.BodyPartLevel2;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.HashMap;
import java.util.List;

@Repository
public class BodyPartLevel2Repository extends BaseRepository{
    public BodyPartLevel2Repository() {
        log = getLogger(this.getClass());

        tableMap = new HashMap<>();
        tableMap.put(Version.DRAFT.getKey(), "body_part_level2");
        tableMap.put(Version.PUBLISHED.getKey(), "body_part_level2_ro");
    }
    public List<BodyPartLevel2> list(Version version, List<String> languageList) {
        return super.list(version, languageList, BodyPartLevel2.class);
    }

}
