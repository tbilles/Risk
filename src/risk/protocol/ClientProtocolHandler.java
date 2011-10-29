package risk.protocol;

import java.io.IOException;

import risk.common.Logger;
import risk.game.Player;
import risk.network.NetworkClient;

public class ClientProtocolHandler {
    private RiskProtocol proto;

    public ClientProtocolHandler(NetworkClient nc) {
        proto = new RiskProtocol(nc);
    }

    public void onConnectionEstablished(Player player) throws IOException {
        Logger.logdebug("Sending HelloCommand");
        proto.sendHello(player);
    }
}
