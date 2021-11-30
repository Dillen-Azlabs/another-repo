package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.Testimonial;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "displayName", "testimonials"})
public class TestimonialListResponse extends BaseResponse {

    @JsonProperty("testimonials")
    private List<Testimonial> list;
    @JsonProperty("count")
    private int count;
    @JsonProperty("displayName")
    private String displayName;

    public TestimonialListResponse(List<Testimonial> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public TestimonialListResponse(List<Testimonial> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Testimonial> getList() {
        return list;
    }

    public void setList(List<Testimonial> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
