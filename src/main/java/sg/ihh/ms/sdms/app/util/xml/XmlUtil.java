package sg.ihh.ms.sdms.app.util.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {

    private static XmlMapper objMapper;

    private static final Logger log = LoggerFactory.getLogger(XmlUtil.class);

    private XmlUtil() {}

    private static void init() {
        objMapper = XmlMapper.builder().defaultUseWrapper(false).enable(SerializationFeature.INDENT_OUTPUT).build();
    }

    public static String toXml(Object obj) {

        if (objMapper == null) {
            init();
        }

        try {
            return objMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("toXml", e);
        }
        return "";
    }
}
