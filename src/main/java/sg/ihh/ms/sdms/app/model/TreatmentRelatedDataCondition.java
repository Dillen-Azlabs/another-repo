package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class TreatmentRelatedDataCondition{

    @JsonProperty("conditionH1Display")
    private String conditionH1Display;
    @JsonProperty("conditionUrl")
    private String itemUrl;

    public TreatmentRelatedDataCondition() {
        //Empty Constructor
    }

    public String getConditionH1Display() {
        return conditionH1Display;
    }
    @ColumnName("condition_h1_display")
    public void setConditionH1Display(String conditionH1Display) {
        this.conditionH1Display = conditionH1Display;
    }

    public String getItemUrl() {
        return itemUrl;
    }
    @ColumnName("item_url")
    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
