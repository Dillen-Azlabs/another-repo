package sg.ihh.ms.sdms.app.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServiceSubAward;

import java.util.List;

@JsonPropertyOrder({"code", "message", "award"})
public class CentreServiceSubAwardListResponse extends BaseResponse {

    @JsonProperty("award")
    private CentreServiceSubAward centreServiceSubAward;

    public CentreServiceSubAwardListResponse(CentreServiceSubAward centreServiceSubAward) {
        super(HttpStatus.OK);
        this.centreServiceSubAward = centreServiceSubAward;
    }

    public CentreServiceSubAward getCentreServiceSubAward() {
        return centreServiceSubAward;
    }

    public void setCentreServiceSubAward(CentreServiceSubAward centreServiceSubAward) {
        this.centreServiceSubAward = centreServiceSubAward;
    }
}
