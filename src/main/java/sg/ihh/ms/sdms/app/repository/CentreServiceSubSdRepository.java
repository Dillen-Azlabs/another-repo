package sg.ihh.ms.sdms.app.repository;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import org.springframework.stereotype.Repository;
import sg.ihh.ms.sdms.app.model.LocationSd;
import sg.ihh.ms.sdms.app.model.LocationSdContact;
import sg.ihh.ms.sdms.app.model.Version;
import sg.ihh.ms.sdms.app.repository.BaseRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CentreServiceSubSdRepository extends BaseRepository {

    public CentreServiceSubSdRepository() {
        log = getLogger(this.getClass());
    }

}
