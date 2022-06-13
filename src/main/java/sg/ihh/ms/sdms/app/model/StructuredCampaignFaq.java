package sg.ihh.ms.sdms.app.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "sectionIntro", "question", "answer", "order", "publishFlag", "createdDt", "modifiedDt"})
public class StructuredCampaignFaq extends BaseModel{

    @JsonProperty("sectionIntro")
    private String sectionIntro;
    @JsonProperty("question")
    private String question;
    @JsonProperty("answer")
    private String answer;

    public StructuredCampaignFaq() {
        //Empty Constructor
    }

    public String getSectionIntro() {
        return sectionIntro;
    }

    public void setSectionIntro(String sectionIntro) {
        this.sectionIntro = sectionIntro;
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
}
