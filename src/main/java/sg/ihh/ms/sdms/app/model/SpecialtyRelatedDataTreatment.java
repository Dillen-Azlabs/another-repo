package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Objects;

public class SpecialtyRelatedDataTreatment {

    @JsonProperty("treatmentH1Display")
    private String treatmentH1Display;
    @JsonProperty("treatmentUrl")
    private String itemUrl;

    public SpecialtyRelatedDataTreatment() {
        //Empty Constructor
    }

    public String getTreatmentH1Display() {
        return treatmentH1Display;
    }
    @ColumnName("treatment_h1_display")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialtyRelatedDataTreatment that = (SpecialtyRelatedDataTreatment) o;
        return treatmentH1Display.equals(that.treatmentH1Display) && itemUrl.equals(that.itemUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treatmentH1Display, itemUrl);
    }
}
