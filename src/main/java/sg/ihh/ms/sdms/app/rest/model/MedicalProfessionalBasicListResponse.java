package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.MedicalProfessionalBasic;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "medicalProfessionals"})
public class MedicalProfessionalBasicListResponse extends BaseResponse {

    @JsonProperty("medicalProfessionals")
    private List<MedicalProfessionalBasic> list;
    @JsonProperty("count")
    private int count;

    public MedicalProfessionalBasicListResponse(List<MedicalProfessionalBasic> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public MedicalProfessionalBasicListResponse(List<MedicalProfessionalBasic> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<MedicalProfessionalBasic> getList() {
        return list;
    }

    public void setList(List<MedicalProfessionalBasic> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
