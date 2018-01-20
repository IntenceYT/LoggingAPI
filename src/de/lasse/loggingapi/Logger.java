package de.lasse.loggingapi;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Logger {

    private static String prefix = "Default";

    public static void log(final String message, final LoggingMode mode) {

        if (mode.equals(LoggingMode.ERROR)) {
            System.err.println(
                    "[" + getCurrentDate() + "] " + prefix + "/" + mode + ": " + message
            );
        }

        if (mode.equals(LoggingMode.INFO)) {
            System.out.println(
                    "[" + getCurrentDate() + "] " + prefix + "/" + mode + ": " + message
            );
        }
    }

    public static void setPrefix(final String prefix) {
        Logger.prefix = prefix;
    }

    private static String getCurrentDate() {
        return ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    }
}
