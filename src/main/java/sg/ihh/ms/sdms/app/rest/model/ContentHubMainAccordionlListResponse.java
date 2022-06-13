package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ContentHubMainAccordion;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count","accordion"})
public class ContentHubMainAccordionlListResponse extends BaseResponse {

    @JsonProperty("accordion")
    private List<ContentHubMainAccordion> list;
    @JsonProperty("count")
    private int count;

    public ContentHubMainAccordionlListResponse(List<ContentHubMainAccordion> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ContentHubMainAccordionlListResponse(List<ContentHubMainAccordion> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }


    public List<ContentHubMainAccordion> getList() {
        return list;
    }

    public void setList(List<ContentHubMainAccordion> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
