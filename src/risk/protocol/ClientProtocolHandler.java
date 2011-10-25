package risk.protocol;

import risk.game.Player;
import risk.network.NetworkClient;

public class ClientProtocolHandler {
    private RiskProtocol proto;

    public ClientProtocolHandler(NetworkClient nc) {
        proto = new RiskProtocol(nc);
    }

    public void onConnectionEstablished(Player player) {
        proto.sendHello(player);
    }
}
