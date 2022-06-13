package sg.ihh.ms.sdms.app.repository;

import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.BodyPartLevel2;
import sg.ihh.ms.sdms.app.model.Version;
import java.util.List;

@Repository
public class BodyPartLevel2Repository extends BaseRepository{
    public BodyPartLevel2Repository() {
        log = getLogger(this.getClass());

        tableName = "body_part_level2";
    }
    public List<BodyPartLevel2> list(Version version, List<String> languageList) {
        return super.list(version, languageList, BodyPartLevel2.class);
    }

}
