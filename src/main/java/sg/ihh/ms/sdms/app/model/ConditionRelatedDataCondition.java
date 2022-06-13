package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class ConditionRelatedDataCondition{

    @JsonProperty("conditionH1Display")
    private String treatmentH1Display;
    @JsonProperty("conditionUrl")
    private String itemUrl;

    public ConditionRelatedDataCondition() {
        //Empty Constructor
    }

    public String getTreatmentH1Display() {
        return treatmentH1Display;
    }
    @ColumnName("condition_h1_display")
    public void setTreatmentH1Display(String treatmentH1Display) {
        this.treatmentH1Display = treatmentH1Display;
    }

    public String getItemUrl() {
        return itemUrl;
    }
    @ColumnName("item_url")
    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
