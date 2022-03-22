package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageAccordion;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count","accordion"})
public class StructuredPageAccordionListResponse extends BaseResponse {

    @JsonProperty("accordion")
    private List<StructuredPageAccordion> list;
    @JsonProperty("count")
    private int count;

    public StructuredPageAccordionListResponse(List<StructuredPageAccordion> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredPageAccordionListResponse(List<StructuredPageAccordion> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredPageAccordion> getList() {
        return list;
    }

    public void setList(List<StructuredPageAccordion> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
