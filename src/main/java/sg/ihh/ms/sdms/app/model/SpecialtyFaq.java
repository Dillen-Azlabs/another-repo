package sg.ihh.ms.sdms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "additionalResources", "question", "answer", "faqMetaTitle", "faqMetaDescription", "order", "publishFlag", "createdDt", "modifiedDt"})
public class SpecialtyFaq extends BaseModel{

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

    public SpecialtyFaq() {
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

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFaqTitle() {
        return faqTitle;
    }

    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqDesc() {
        return faqDesc;
    }

    public void setFaqDesc(String faqDesc) {
        this.faqDesc = faqDesc;
    }
}
