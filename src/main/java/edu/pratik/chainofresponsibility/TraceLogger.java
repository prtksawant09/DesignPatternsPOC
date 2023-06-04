package edu.pratik.chainofresponsibility;

public class TraceLogger extends Logger {
    public TraceLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logger, String message) {
        if(logger==TRACE)
            System.out.println("TRACE: "+message);
        else
            super.log(logger, message);
    }
}
