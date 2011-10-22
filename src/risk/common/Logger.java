package risk.common;

import risk.common.LogLevel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

public class Logger {
    private String logFile;
    private FileWriter wr;
    private boolean logToConsole;
    private boolean initialized;
    private LogLevel logLevel = LogLevel.TRACE;
    static private Logger instance = new Logger();
    private final String endLine = "\r\n";
    
    static public Logger getInstance() {
        return instance;
    }
    
    public void initialize(boolean logToConsole, String logFile) {
        this.logToConsole = logToConsole;
        this.logFile = logFile;
        if (this.logFile != null) {
            try {
                wr = new FileWriter(logFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        initialized = true;
    }
    
    private void log(LogLevel level, String msg) {
        if (!initialized)
            throw new RuntimeException("Logger not initialized!");
        
        if (level.ordinal() < logLevel.ordinal()) {
            return ;
        }
        
        StringBuilder logMsg = new StringBuilder();
        Date d = new Date();
        
        logMsg.append(d.toString());
        logMsg.append(" - [");
        logMsg.append(level.toString());
        logMsg.append("] ");
        logMsg.append(msg);
        logMsg.append(endLine);
        
        if (logFile != null) {
            try {
                wr.write(logMsg.toString());
                wr.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if (logToConsole) {
            System.out.print(logMsg.toString());
        }
    }
    
    private void log(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Exception: ");
        sb.append(e.toString());
        sb.append(e.getMessage());
        sb.append(endLine);
        sb.append("    Stack trace:" + endLine);
        StackTraceElement[] stkElements = e.getStackTrace();
        for (StackTraceElement stkFrame : stkElements) {
            sb.append("        in " + stkFrame.getClassName() + "." + stkFrame.getMethodName() + " ");
            sb.append("at " + stkFrame.getFileName() + ":" + stkFrame.getLineNumber());
            sb.append(endLine);
        }
        
        log(LogLevel.ERROR, sb.toString());
    }
    
    static public void logtrace(String msg) {
        getInstance().log(LogLevel.TRACE, msg);
    }
    
    static public void logdebug(String msg) {
        getInstance().log(LogLevel.DEBUG, msg);
    }
    
    static public void loginfo(String msg) {
        getInstance().log(LogLevel.INFO, msg);
    }
    
    static public void logwarn(String msg) {
        getInstance().log(LogLevel.WARNING, msg);
    }
    
    static public void logerror(String msg) {
        getInstance().log(LogLevel.ERROR, msg);
    }
    
    static public void logexception(Exception e) {
        getInstance().log(e);
    }
}
