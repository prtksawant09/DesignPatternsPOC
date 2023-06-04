package edu.pratik.chainofresponsibility;

public class DebugLogger extends Logger {

    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logger, String message) {
        if(logger==DEBUG)
            System.out.println("DEBUG: "+message);
        else
            super.log(logger, message);
    }
}
