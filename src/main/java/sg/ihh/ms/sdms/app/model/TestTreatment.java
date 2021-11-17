
package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "testTreatment", "order", "publishFlag", "createdDt", "modifiedDt"})
public class TestTreatment extends BaseModel {

    @JsonProperty("testTreatment")
    private String testTreatment;

    public TestTreatment() {
        // Empty Constructor
    }

    public String getTestTreatment() {
        return testTreatment;
    }

    @ColumnName("test_treatment")
    public void setTestTreatment(String testTreatment) {
        this.testTreatment = testTreatment;
    }

}
