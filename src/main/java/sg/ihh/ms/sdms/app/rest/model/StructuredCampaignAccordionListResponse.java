package sg.ihh.ms.sdms.app.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredCampaignAccordion;
import sg.ihh.ms.sdms.app.model.StructuredPageAccordion;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count","accordion"})
public class StructuredCampaignAccordionListResponse extends BaseResponse {


    @JsonProperty("accordion")
    private List<StructuredCampaignAccordion> list;
    @JsonProperty("count")
    private int count;


    public StructuredCampaignAccordionListResponse(List<StructuredCampaignAccordion> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredCampaignAccordionListResponse(List<StructuredCampaignAccordion> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredCampaignAccordion> getList() {
        return list;
    }

    public void setList(List<StructuredCampaignAccordion> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
