package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;


public class ConditionSdFaq{


    @JsonProperty("question")
    private String question;
    @JsonProperty("answer")
    private String answer;
    @JsonProperty("order")
    private String displayOrder;


    public ConditionSdFaq() {
        //Empty Constructor
    }


    public String getQuestion() {
        return question;
    }
    @ColumnName("question")
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }
    @ColumnName("answer")
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }
}
