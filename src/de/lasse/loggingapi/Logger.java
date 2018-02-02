package de.lasse.loggingapi;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Logger {

    private static String prefix = "Default";

    public static void log(final String message, final LoggingMode mode) {

        final String output = "[" + getCurrentDate() + "] " + prefix + "/" + mode + ": " + message;

        if (mode.equals(LoggingMode.ERROR)) {
            System.err.println(output);
        }

        if (mode.equals(LoggingMode.INFO)) {
            System.out.println(output);
        }
    }

    public static void setPrefix(final String prefix) {
        Logger.prefix = prefix;
    }

    private static String getCurrentDate() {
        return ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    }
}
