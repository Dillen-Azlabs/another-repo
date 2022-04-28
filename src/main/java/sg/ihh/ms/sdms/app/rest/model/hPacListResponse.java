package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sg.ihh.ms.sdms.app.model.Pac;
import sg.ihh.ms.sdms.app.model.hPac;

@JsonPropertyOrder({ "code", "message", "count", "country", "displayName", "pac" })
public class hPacListResponse extends BaseResponse {

	@JsonProperty("pac")
	private List<hPac> list;
	@JsonProperty("count")
	private int count;
	@JsonProperty("country")
	private String country;
	@JsonProperty("displayName")
	private String displayName;

	public hPacListResponse(List<hPac> result) {
		super(HttpStatus.OK);
		this.count = result.size();
		this.list = result;
	}

	public hPacListResponse(List<hPac> list, int count) {
		super(HttpStatus.OK);
		this.count = count;
		this.list = list;
	}

	public List<hPac> getList() {
		return list;
	}

	public void setList(List<hPac> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
