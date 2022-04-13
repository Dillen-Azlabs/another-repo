package sg.ihh.ms.sdms.app.rest.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import sg.ihh.ms.sdms.app.model.HresidenceCountry;

public class HresidenceCountryListResponse extends BaseResponse {

	@JsonProperty("cor")
	private List<HresidenceCountry> list;
	@JsonProperty("count")
	private int count;
	
	
	
	public HresidenceCountryListResponse(List<HresidenceCountry> list) {
		super(HttpStatus.OK);
		this.list = list;
		this.count = count;
	}
	
	public List<HresidenceCountry> getList() {
		return list;
	}
	public void setList(List<HresidenceCountry> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
