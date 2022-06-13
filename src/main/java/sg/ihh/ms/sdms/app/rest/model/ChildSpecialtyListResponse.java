package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.ChildSpecialty;

import java.util.List;

public class ChildSpecialtyListResponse extends BaseResponse{
    @JsonProperty("childSpecialties")
    private List<ChildSpecialty> list;
    @JsonProperty("count")
    private int count;


    public ChildSpecialtyListResponse(List<ChildSpecialty> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ChildSpecialtyListResponse(List<ChildSpecialty> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ChildSpecialty> getList() {
        return list;
    }

    public void setList(List<ChildSpecialty> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
