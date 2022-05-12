package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServiceSubBasicDetail;


@JsonPropertyOrder({"code", "message", "centreServiceS"})
public class CentreServiceSubBasicDetailListResponse extends BaseResponse{

    @JsonProperty("centreServiceS")
    private CentreServiceSubBasicDetail centreServiceSubBasicDetail;

    public CentreServiceSubBasicDetailListResponse(CentreServiceSubBasicDetail centreServiceSubBasicDetail) {
        super(HttpStatus.OK);
        this.centreServiceSubBasicDetail = centreServiceSubBasicDetail;
    }

    public CentreServiceSubBasicDetail getCentreServiceSubBasicDetail() {
        return centreServiceSubBasicDetail;
    }

    public void setCentreServiceSubBasicDetail(CentreServiceSubBasicDetail centreServiceSubBasicDetail) {
        this.centreServiceSubBasicDetail = centreServiceSubBasicDetail;
    }
}
