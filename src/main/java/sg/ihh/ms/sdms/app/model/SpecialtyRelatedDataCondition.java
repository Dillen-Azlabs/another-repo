package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Objects;

public class SpecialtyRelatedDataCondition {

    @JsonProperty("conditionH1Display")
    private String conditionH1Display;
    @JsonProperty("conditionUrl")
    private String itemUrl;

    public SpecialtyRelatedDataCondition() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialtyRelatedDataCondition that = (SpecialtyRelatedDataCondition) o;
        return conditionH1Display.equals(that.conditionH1Display) && itemUrl.equals(that.itemUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conditionH1Display, itemUrl);
    }
}
