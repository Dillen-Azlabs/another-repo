package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.TestTreatment;
import sg.ihh.ms.sdms.app.model.Treatment;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "testTreatments"})
public class TestTreatmentListResponse extends BaseResponse {

    @JsonProperty("testTreatments")
    private List<TestTreatment> list;
    @JsonProperty("count")
    private int count;


    public TestTreatmentListResponse(List<TestTreatment> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public TestTreatmentListResponse(List<TestTreatment> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<TestTreatment> getList() {
        return list;
    }

    public void setList(List<TestTreatment> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
