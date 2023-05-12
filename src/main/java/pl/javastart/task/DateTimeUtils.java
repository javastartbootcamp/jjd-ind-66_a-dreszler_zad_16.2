package pl.javastart.task;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

class DateTimeUtils {
    private static final DateTimeFormatter OUTPUT_DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static ZonedDateTime parseDateTime(String[] splitDateTime, String pattern) {
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(splitDateTime[0], datePattern);
        LocalTime time;
        if (splitDateTime.length == 2) {
            time = LocalTime.parse(splitDateTime[1]);
        } else {
            time = LocalTime.of(0, 0);
        }

        ZonedDateTime dateTime = ZonedDateTime.of(date, time, ZoneId.systemDefault());

        return dateTime;
    }

    static String formatDateTime(ZonedDateTime dateTime) {
        return dateTime.format(OUTPUT_DTF);
    }

    static Map<String, ZonedDateTime> convertDateTime(ZonedDateTime dateTime) {
        Map<String, ZonedDateTime> convertedDateTimes = new LinkedHashMap<>();
        for (TimeZone zone : TimeZone.values()) {
            convertedDateTimes.put(zone.getPlName(), dateTime.withZoneSameInstant(ZoneId.of(zone.getZoneId())));
        }

        return convertedDateTimes;
    }
}
