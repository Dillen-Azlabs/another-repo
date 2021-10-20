package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.MedicalProfession;

public class MedicalProfessionListResponse extends BaseResponse {

    @JsonProperty("medicalProfessions")
    private List<MedicalProfession> list;

    @JsonProperty("count")
    private int count;

    public MedicalProfessionListResponse(List<MedicalProfession> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public MedicalProfessionListResponse(List<MedicalProfession> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }


    public List<MedicalProfession> getList() {
        return list;
    }

    public void setList(List<MedicalProfession> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
