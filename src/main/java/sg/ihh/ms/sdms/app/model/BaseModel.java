package sg.ihh.ms.sdms.app.model;

import java.time.LocalDateTime;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class BaseModel {

    @JsonProperty("uid")
    protected String uid;

    @JsonProperty("languageCode")
    protected String languageCode;

    @JsonProperty("createdDt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime createdDt;

    @JsonProperty("modifiedDt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime modifiedDt;

    @JsonProperty("publishFlag")
    protected boolean publishFlag;

    @JsonProperty("order")
    protected int order;


    public BaseModel() {
        // Empty Constructor
    }

    public String getUid() {
        return uid;
    }

    @ColumnName("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    @ColumnName("language_code")
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    @ColumnName("created_dt")
    public void setCreatedDt(LocalDateTime createdDt) {
        this.createdDt = createdDt;
    }

    public LocalDateTime getModifiedDt() {
        return modifiedDt;
    }

    @ColumnName("modified_dt")
    public void setModifiedDt(LocalDateTime modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    public int getOrder() {
        return order;
    }

    @ColumnName("display_order")
    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isPublishFlag() {
        return publishFlag;
    }

    @ColumnName("publish_flag")
    public void setPublishFlag(boolean publishFlag) {
        this.publishFlag = publishFlag;
    }

}
