package com.lixiong;

public class CustomLogger {

    private static CustomLogger logger = null;

    private CustomLogger() {

    }

    public static CustomLogger getLogger() {
        if (logger == null) {
            logger = new CustomLogger();
            return logger;
        }
        return logger;
    }

    public void info(String message) {
        getLogger().info(message);
    }

    public void error(String message) {
        getLogger().error(message);

    }
    public void warning(String message) {
        getLogger().warning(message);
    }

    public void debug(String message) {
        getLogger().debug(message);
    }
}
