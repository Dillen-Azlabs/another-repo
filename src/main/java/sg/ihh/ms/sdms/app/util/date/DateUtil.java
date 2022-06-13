package sg.ihh.ms.sdms.app.util.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private DateUtil() {}

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return DATETIME_FORMATTER.format(localDateTime);
    }

    public static String formatLocalDate(LocalDate localDate) {
        return DATE_FORMATTER.format(localDate);
    }

}
