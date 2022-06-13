package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.BodyPartLevel2;

import java.util.List;

public class BodyPartLevel2ListResponse extends BaseResponse{
    @JsonProperty("bodyParts")
    private List<BodyPartLevel2> list;
    @JsonProperty("count")
    private int count;


    public BodyPartLevel2ListResponse(List<BodyPartLevel2> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public BodyPartLevel2ListResponse(List<BodyPartLevel2> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<BodyPartLevel2> getList() {
        return list;
    }

    public void setList(List<BodyPartLevel2> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
