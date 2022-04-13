package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid","language","cor","order","publishFlag","createdDt", "modifiedDt"})
public class HresidenceCountry extends BaseModel{

	
	@JsonProperty("cor")
	private String cor;
	
	public HresidenceCountry()
	{
		//EmptyConstructor
	}
	
	public String getCor()
	{
		return cor;
	}
	
	public void setCor(String cor)
	{
	    this.cor = cor;
	}
	
	
}
