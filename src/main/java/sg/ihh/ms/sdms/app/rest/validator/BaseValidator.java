package sg.ihh.ms.sdms.app.rest.validator;

public class BaseValidator {

    public boolean notNull(Object obj) {
        return null != obj;
    }

    public static boolean validate(String str) {
        return null != str && !str.trim().isEmpty();
    }
}
