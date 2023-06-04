package edu.pratik.chainofresponsibility;

public class InfoLogger extends Logger{

    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(int logger, String message) {
        if(logger==INFO)
            System.out.println("INFO: "+ message);
        else
            super.log(logger, message);
    }
}
