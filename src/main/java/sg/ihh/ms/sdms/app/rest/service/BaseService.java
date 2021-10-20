package sg.ihh.ms.sdms.app.rest.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;

public class BaseService {

    protected Logger log;

    public BaseService() {
        // Empty Constructor
    }

    @Value("${app.langauge.default}")
    private String defaultLanguageCode;


    protected Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    protected void start(String methodName) {
        log.debug("[{}] Start", methodName);
    }

    protected void completed(String methodName) {
        log.debug("[{}] Completed", methodName);
    }

    protected BaseResponse buildSuccessResponse() {
        return new BaseResponse(HttpStatus.OK);
    }

    protected BaseResponse buildErrorResponse() {
        return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected List<String> getLanguageList(String languageCode) {
        List<String> list = new ArrayList<>();
        list.add(defaultLanguageCode);
        list.add(languageCode);
        return list;
    }

}
