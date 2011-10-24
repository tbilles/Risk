package risk.common;

public enum LogLevel {
    /**
     * Debug is a level that help to find out what and WHERE went wrong.
     */
    DEBUG,
    
    /**
     * Info just informs us about something that was EXPECTED to happen.
     */
    INFO,
    
    /**
     * Warning tells us that something UNEXPECTED happened, BUT it does NOT AFFFECT NORMAL program flow.
     */
    WARNING,
    
    /**
     * Error is an event that is UNEXPECTED and normal program flow CAN'T go on.
     */
    ERROR
    
    /**
     * A set of examples each in the topic of a client trying to connect to a server:
     * DEBUG - "Connecting to server" It's debug, because it tells us what (and implicitly WHERE) does the program trying to do
     * INFO - "Connected to server" It is perfectly expected to happen, but still good to know that the connection was successfully established.
     * WARNING - "Timeout expired, trying again..." It was unexpected, but the program is trying to connect again, so far the program can handle the unexpected event.
     * ERROR - "Can't connect after 5 tries. Gave up." This is an error, that the program can't handle on it's own, so we call it an ERROR.
     */
};
