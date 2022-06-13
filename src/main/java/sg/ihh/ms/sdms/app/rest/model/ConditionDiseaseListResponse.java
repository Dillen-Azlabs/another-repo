package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import sg.ihh.ms.sdms.app.model.ConditionDisease;

public class ConditionDiseaseListResponse extends BaseResponse {

    @JsonProperty("conditionsDiseases")
    private List<ConditionDisease> list;
    @JsonProperty("count")
    private int count;


    public ConditionDiseaseListResponse(List<ConditionDisease> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public ConditionDiseaseListResponse(List<ConditionDisease> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<ConditionDisease> getList() {
        return list;
    }

    public void setList(List<ConditionDisease> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
