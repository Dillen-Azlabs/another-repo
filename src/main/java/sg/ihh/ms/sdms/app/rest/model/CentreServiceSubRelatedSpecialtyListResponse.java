package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServiceSubRelatedSpecialties;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "relatedSpecialties"})
public class CentreServiceSubRelatedSpecialtyListResponse extends BaseResponse {
    @JsonProperty("relatedSpecialties")
    private List<CentreServiceSubRelatedSpecialties> list;
    @JsonProperty("count")
    private int count;

    public CentreServiceSubRelatedSpecialtyListResponse(List<CentreServiceSubRelatedSpecialties> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public CentreServiceSubRelatedSpecialtyListResponse(List<CentreServiceSubRelatedSpecialties> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }


}
