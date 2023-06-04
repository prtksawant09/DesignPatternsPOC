package edu.pratik.chainofresponsibility;

public class ErrorLogger extends Logger {
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logger, String message) {
        if(logger==ERROR)
            System.out.println("ERROR: "+message);
        else
            super.log(logger, message);
    }
}
