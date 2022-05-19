package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredCampaignBodySections;

import java.util.List;


@JsonPropertyOrder({"code", "message", "count", "bodySections"})
public class StructuredCampaignBodySectionsResponse extends BaseResponse{

    @JsonProperty("bodySections")
    private List<StructuredCampaignBodySections> list;
    @JsonProperty("count")
    private int count;

    public StructuredCampaignBodySectionsResponse(List<StructuredCampaignBodySections> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }
    public StructuredCampaignBodySectionsResponse(List<StructuredCampaignBodySections> list, int count) {
        super(HttpStatus.OK);
        this.list = list;
        this.count = list.size();
        this.list = list;
    }

    public List<StructuredCampaignBodySections> getList() {
        return list;
    }

    public void setList(List<StructuredCampaignBodySections> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
