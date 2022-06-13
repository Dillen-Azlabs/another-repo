package sg.ihh.ms.sdms.app.rest.model;

import org.springframework.http.HttpStatus;

public class BaseResponse {

    private int code;
    private String message;

    public BaseResponse(HttpStatus status) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
