package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageWhyChooseUs;


import java.util.List;

@JsonPropertyOrder({"code", "message", "count","structuredPage"})
public class StructuredPageWhyChooseUsListResponse extends BaseResponse {

    @JsonProperty("structuredPage")
    private List<StructuredPageWhyChooseUs> list;
    @JsonProperty("count")
    private int count;

    public StructuredPageWhyChooseUsListResponse(List<StructuredPageWhyChooseUs> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredPageWhyChooseUsListResponse(List<StructuredPageWhyChooseUs> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredPageWhyChooseUs> getList() {
        return list;
    }

    public void setList(List<StructuredPageWhyChooseUs> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
