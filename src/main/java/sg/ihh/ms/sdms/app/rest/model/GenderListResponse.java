package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.Gender;

public class GenderListResponse extends BaseResponse {

    @JsonProperty("genders")
    private List<Gender> list;
    @JsonProperty("count")
    private int count;


    public GenderListResponse(List<Gender> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public GenderListResponse(List<Gender> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Gender> getList() {
        return list;
    }

    public void setList(List<Gender> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
