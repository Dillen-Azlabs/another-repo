package sg.ihh.ms.sdms.app.util.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {

    private static ObjectMapper objMapper;

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {}

    private static void init() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objMapper = objectMapper;
    }

    public static String toJson(Object obj) {

        if (objMapper == null) {
            init();
        }

        try {
            return objMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("toJson", e);
        }
        return "";
    }

}
