package risk.protocol;

import java.io.IOException;

import risk.common.Logger;
import risk.game.Player;
import risk.network.NetworkClient;
import risk.network.QueuedSender;

public class ClientProtocolHandler extends RiskProtocol {
    public ClientProtocolHandler(QueuedSender sender) {
        super(sender);
    }

    public void onConnectionEstablished(String name) throws IOException {
        sendHello(name);
    }
}
