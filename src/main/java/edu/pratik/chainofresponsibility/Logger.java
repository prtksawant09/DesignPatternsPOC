package edu.pratik.chainofresponsibility;

public abstract class Logger {
    public static final int TRACE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int ERROR = 4;
    Logger nextLogger;
    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(int logger, String message) {
        if (nextLogger != null)
            nextLogger.log(logger, message);
    }
}
