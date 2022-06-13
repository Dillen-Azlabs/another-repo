package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServiceSubBodySection;
import sg.ihh.ms.sdms.app.model.ContentHubSubBodySection;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "bodySections"})
public class CentreServiceBodySectionListResponse extends BaseResponse{
    @JsonProperty("bodySections")
    private List<CentreServiceSubBodySection> list;
    @JsonProperty("count")
    private int count;


    public CentreServiceBodySectionListResponse(List<CentreServiceSubBodySection> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public CentreServiceBodySectionListResponse(List<CentreServiceSubBodySection> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }
}
