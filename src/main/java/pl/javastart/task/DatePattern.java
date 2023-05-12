package pl.javastart.task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public enum DatePattern {
    PATTERN1("yyyy-MM-dd"),
    PATTERN2("dd.MM.yyyy");

    private final String pattern;

    DatePattern(String pattern) {
        this.pattern = pattern;
    }

    public static String getPattern(String dateStr) {
        for (DatePattern patt : values()) {
            if (isValid(patt.pattern, dateStr)) {
                return patt.pattern;
            }
        }

        return null;
    }

    private static boolean isValid(String pattern, String dateStr) {
        try {
            DateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }
}
