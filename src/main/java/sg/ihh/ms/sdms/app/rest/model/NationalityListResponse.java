package sg.ihh.ms.sdms.app.rest.model;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.Nationality;

import java.util.List;

public class NationalityListResponse extends BaseResponse{
    @JsonProperty("nationalities")
    private List<Nationality> list;
    @JsonProperty("count")
    private int count;


    public NationalityListResponse(List<Nationality> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public NationalityListResponse(List<Nationality> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Nationality> getList() {
        return list;
    }

    public void setList(List<Nationality> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
