package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageFaq;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "faqs"})
public class StructuredPageFaqListResponse extends BaseResponse {

    @JsonProperty("faqs")
    private List<StructuredPageFaq> list;
    @JsonProperty("count")
    private int count;

    public StructuredPageFaqListResponse(List<StructuredPageFaq> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredPageFaqListResponse(List<StructuredPageFaq> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredPageFaq> getList() {
        return list;
    }

    public void setList(List<StructuredPageFaq> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
