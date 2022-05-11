package sg.ihh.ms.sdms.app.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.HighlightsSearch;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "highlights"})
public class HighlightsSearchResponse extends  BaseResponse{

    @JsonProperty("highlights")
    private List<HighlightsSearch> list;

    @JsonProperty("count")
    private int count;


    public HighlightsSearchResponse(List<HighlightsSearch> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public HighlightsSearchResponse(List<HighlightsSearch> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

}
