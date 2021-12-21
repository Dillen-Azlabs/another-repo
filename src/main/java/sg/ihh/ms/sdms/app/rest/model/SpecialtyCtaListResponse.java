package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.SpecialtyCta;

import java.util.List;

@JsonPropertyOrder({"code", "message", "specialty"})
public class SpecialtyCtaListResponse extends BaseResponse{
    @JsonProperty("specialty")
    private List<SpecialtyCta> list;

    public SpecialtyCtaListResponse(List<SpecialtyCta> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<SpecialtyCta> getList() {
        return list;
    }

    public void setList(List<SpecialtyCta> list) {
        this.list = list;
    }
}
