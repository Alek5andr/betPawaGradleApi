package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    // Initialize Log4j instance
    private static final Logger LOGGER = LogManager.getLogger(Log.class);

    // Info Level Logs
    public static void info (String message) {
        LOGGER.info(message);
    }

    // Debug Level Logs
    public static void debug(String message) {
        LOGGER.debug(message);
    }

    // Warn Level Logs
    public static void warn (String message) {
        LOGGER.warn(message);
    }

    // Error Level Logs
    public static void error (String message) {
        LOGGER.error(message);
    }
}
