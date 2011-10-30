package risk.game.client;

import java.io.IOException;
import java.net.SocketTimeoutException;

import risk.common.Logger;
import risk.common.Settings;
import risk.game.*;
import risk.network.NetworkClient;
import risk.protocol.ClientProtocolHandler;
import risk.protocol.command.Command;

public class GameClient extends Thread implements GameView, GameController {
    private static final int SOCKET_INTERRUPT_TIMEOUT = 1000;

    private NetworkClient nc;
    private ClientProtocolHandler cph;
    private boolean isConnected;
    private Player myPlayer;
    private Game game;

    public void ConnectToServer() throws IOException {
        String address = Settings.getInstance().getClientConnectAddr();
        int port = Settings.getInstance().getClientConnectPort();
        myPlayer = new Player(Settings.getInstance().getPlayerName());

        nc = new NetworkClient(SOCKET_INTERRUPT_TIMEOUT, false);
        nc.connect(address, port);
        isConnected = true;
        Logger.loginfo("Connected to server");
        game = new Game();
        cph = new ClientProtocolHandler(nc);
        cph.onConnectionEstablished(myPlayer);
    }
    
    @Override
    public void run() {
        try {
            Logger.loginfo("Client started");
            try {
                ConnectToServer();
            } catch (IOException e) {
                Logger.logexception(e, "Cannot connect to server");
            }
            
            Logger.loginfo("Connected to server");
            while (!interrupted()) {
                try {
                    Command cmd = nc.readCommand();
                    //cph.onCommand(cmd);
                } catch (SocketTimeoutException e) {
                } catch (IOException e) {
                    Logger.logexception(e, "Couldn't read Command");
                }
            }
        } catch (Exception e) {
            Logger.logexception(e, "Unhandled exception");
        } finally {
            Logger.loginfo("Client stops");
        }
    }

}
