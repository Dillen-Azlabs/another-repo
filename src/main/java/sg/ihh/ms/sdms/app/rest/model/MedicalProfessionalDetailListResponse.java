package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.MedicalProfessionalBasic;
import sg.ihh.ms.sdms.app.model.MedicalProfessionalDetail;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "medicalProfessionals"})
public class MedicalProfessionalDetailListResponse extends BaseResponse {

    @JsonProperty("medicalProfessionals")
    private List<MedicalProfessionalDetail> list;
    @JsonProperty("count")
    private int count;

    public MedicalProfessionalDetailListResponse(List<MedicalProfessionalDetail> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public MedicalProfessionalDetailListResponse(List<MedicalProfessionalDetail> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<MedicalProfessionalDetail> getList() {
        return list;
    }

    public void setList(List<MedicalProfessionalDetail> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
