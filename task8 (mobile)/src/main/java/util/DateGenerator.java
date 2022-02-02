package util;

import java.time.LocalDateTime;

public class DateGenerator {
    public static String getCurrentDate() {
        return LocalDateTime.now().toString();
    }
}
