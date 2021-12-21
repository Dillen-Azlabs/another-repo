package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@JsonPropertyOrder({"uid", "languageCode", "additionalResources", "question", "answer","faqMetaTitle","faqMetaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class ConditionFaq extends BaseModel{

    @JsonProperty("additionalResources")
    private String additionalResource;
    @JsonProperty("question")
    private String question;
    @JsonProperty("answer")
    private String answer;
    @JsonProperty("faqMetaTitle")
    private String faqTitle;
    @JsonProperty("faqMetaDescription")
    private String faqDesc;

    public ConditionFaq() {
        //Empty Constructor
    }

    public String getAdditionalResource() {
        return additionalResource;
    }

    public void setAdditionalResource(String additionalResource) {
        this.additionalResource = additionalResource;
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

    public String getFaqTitle() {
        return faqTitle;
    }
    @ColumnName("faq_title")
    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqDesc() {
        return faqDesc;
    }
    @ColumnName("faq_desc")
    public void setFaqDesc(String faqDesc) {
        this.faqDesc = faqDesc;
    }
}
