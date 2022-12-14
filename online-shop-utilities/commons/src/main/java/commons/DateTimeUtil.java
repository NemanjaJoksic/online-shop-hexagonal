package commons;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {

    public static LocalDateTime getNowUTC() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

}
