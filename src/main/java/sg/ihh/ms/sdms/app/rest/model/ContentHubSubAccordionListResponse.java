package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubSubAccordion;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count","accordion"})
public class ContentHubSubAccordionListResponse extends BaseResponse {

    @JsonProperty("accordion")
    private List<ContentHubSubAccordion> list;
    @JsonProperty("count")
    private int count;

    public ContentHubSubAccordionListResponse(List<ContentHubSubAccordion> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubSubAccordionListResponse(List<ContentHubSubAccordion> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ContentHubSubAccordion> getList() {
        return list;
    }

    public void setList(List<ContentHubSubAccordion> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
