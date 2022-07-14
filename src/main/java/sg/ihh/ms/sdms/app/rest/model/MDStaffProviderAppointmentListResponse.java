package sg.ihh.ms.sdms.app.rest.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.MDStaffProviderAppointment;

import java.util.List;
@JsonPropertyOrder({"code", "message", "count", "mcrNumber", "appointments"})
public class MDStaffProviderAppointmentListResponse extends BaseResponse {

    @JsonProperty("appointments")
    private List<MDStaffProviderAppointment> list;
    @JsonProperty("count")
    private int count;
    @JsonProperty("mcrNumber")
    private String mcrNumber;

    public MDStaffProviderAppointmentListResponse(List<MDStaffProviderAppointment> list) {
        super(HttpStatus.OK);
        this.count = list.size();
        this.list = list;
    }

    public MDStaffProviderAppointmentListResponse(List<MDStaffProviderAppointment> list, int count) {
        super(HttpStatus.OK);
        this.count = count;
        this.list = list;
    }

    public List<MDStaffProviderAppointment> getList() {
        return list;
    }

    public void setList(List<MDStaffProviderAppointment> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

	public String getMcrNumber() {
		return mcrNumber;
	}

	public void setMcrNumber(String mcrNumber) {
		this.mcrNumber = mcrNumber;
	}
    
}