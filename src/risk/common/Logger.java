package risk.common;

import risk.common.LogLevel;
import risk.utils.RiskIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

public class Logger {
    private String logFile;
    private FileWriter wr;
    private boolean logToConsole;
    private boolean initialized;
    private LogLevel logLevel = LogLevel.DEBUG;
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
            return;
        }

        StringBuilder logMsgBuilder = new StringBuilder();
        Date d = new Date();

        logMsgBuilder.append(d.toString());
        logMsgBuilder.append(" - [");
        logMsgBuilder.append(level.toString());
        logMsgBuilder.append("] ");
        logMsgBuilder.append(msg);
        logMsgBuilder.append(endLine);

        String logMsg = logMsgBuilder.toString();

        // Log to file
        if (logFile != null) {
            try {
                wr.write(logMsg);
                wr.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Log to console
        if (logToConsole) {
            System.out.print(logMsg);
        }

        // Log to GUI
        if (Thread.currentThread().getName().compareTo("GameServerThread") == 0) {
            RiskIO.serverPrintln(logMsg);
        } else {
            RiskIO.clientPrintln(logMsg);
        }
    }

    private void log(Exception e, String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg + endLine);
        appendException(e, sb);

        log(LogLevel.ERROR, sb.toString());
    }

    private void appendException(Throwable e, StringBuilder sb) {
        sb.append("    Exception: ");
        sb.append(e.toString());
        sb.append(endLine);
        sb.append("    Stack trace:" + endLine);
        StackTraceElement[] stkElements = e.getStackTrace();
        for (StackTraceElement stkFrame : stkElements) {
            sb.append("        in " + stkFrame.getClassName() + "."
                    + stkFrame.getMethodName() + " ");
            sb.append("at " + stkFrame.getFileName() + ":"
                    + stkFrame.getLineNumber());
            sb.append(endLine);
        }
        if (e.getCause() != null) {
            appendException(e.getCause(), sb);
        }
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

    static public void logexception(Exception e, String msg) {
        getInstance().log(e, msg);
    }
}
