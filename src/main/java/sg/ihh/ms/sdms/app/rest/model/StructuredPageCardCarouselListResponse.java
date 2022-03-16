package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageCardCarousel;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "cardCarousel"})
public class StructuredPageCardCarouselListResponse extends BaseResponse {

    @JsonProperty("cardCarousel")
    private List<StructuredPageCardCarousel> list;
    @JsonProperty("count")
    private int count;

    public StructuredPageCardCarouselListResponse(List<StructuredPageCardCarousel> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public StructuredPageCardCarouselListResponse(List<StructuredPageCardCarousel> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<StructuredPageCardCarousel> getList() {
        return list;
    }

    public void setList(List<StructuredPageCardCarousel> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
