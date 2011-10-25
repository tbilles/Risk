package risk.game.client;

import java.io.IOException;

import risk.common.Settings;
import risk.game.*;
import risk.network.NetworkClient;
import risk.protocol.ClientProtocolHandler;

public class GameClient implements GameView, GameController {
    private NetworkClient networkClient;
    private ClientProtocolHandler cph;
    private boolean isConnected;
    private Player myPlayer;
    private Game game;

    public void ConnectToServer() throws IOException {
        String address = Settings.getInstance().getClientConnectAddr();
        int port = Settings.getInstance().getClientConnectPort();
        myPlayer = new Player(Settings.getInstance().getPlayerName());

        networkClient.connect(address, port);
        isConnected = true;
        game = new Game();
        cph = new ClientProtocolHandler(networkClient);
        cph.onConnectionEstablished(myPlayer);
    }

}
