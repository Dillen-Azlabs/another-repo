package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.MedicalProfessionalDetail;
import sg.ihh.ms.sdms.app.model.Portfolio;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "medicalProfessional"})
public class PortfolioListResponse extends BaseResponse {

    @JsonProperty("medicalProfessional")
    private List<Portfolio> list;
    @JsonProperty("count")
    private int count;

    public PortfolioListResponse(List<Portfolio> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public PortfolioListResponse(List<Portfolio> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<Portfolio> getList() {
        return list;
    }

    public void setList(List<Portfolio> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
