package risk.common;

public class Settings {
    private int serverListenPort = 34343;
    private String clientConnectAddr = "localhost";
    private int clientConnectPort = 34343;
    private String playerName = "player";
    static private Settings instance = new Settings();

    public static Settings getInstance() {
        return instance;
    }

    /**
     * Get the port on which the server starts to listen.
     */
    public int getServerListenPort() {
        return serverListenPort;
    }

    /**
     * Set the port on which the server starts to listen.
     */
    public void setServerListenPort(int serverListenPort) {
        this.serverListenPort = serverListenPort;
    }

    /**
     * Get the IP or the domain the client connects to.
     */
    public String getClientConnectAddr() {
        return clientConnectAddr;
    }

    /**
     * Set the IP or the domain the client connects to.
     */
    public void setClientConnectAddr(String clientConnectAddr) {
        this.clientConnectAddr = clientConnectAddr;
    }

    /**
     * Get the port the client connects to.
     */
    public int getClientConnectPort() {
        return clientConnectPort;
    }

    /**
     * Set the port the client connects to.
     */
    public void setClientConnectPort(int clientConnectPort) {
        this.clientConnectPort = clientConnectPort;
    }

    /**
     * Gets the name of the player.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the name of the player.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
