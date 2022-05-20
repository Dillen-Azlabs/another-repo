package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredCampaignSd;
import java.util.List;


@JsonPropertyOrder({"code", "message", "count","structuredCampaign"})
public class StructuredCampaignSdResponse extends BaseResponse {

    @JsonProperty("structuredCampaign")
    private List<StructuredCampaignSd> list;
    @JsonProperty("count")
    private int count;

    public StructuredCampaignSdResponse(List<StructuredCampaignSd> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredCampaignSdResponse(List<StructuredCampaignSd> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredCampaignSd> getList() {
        return list;
    }

    public void setList(List<StructuredCampaignSd> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
