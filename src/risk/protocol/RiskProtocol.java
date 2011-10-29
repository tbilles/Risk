package risk.protocol;

import java.io.IOException;

import risk.common.Logger;
import risk.game.Player;
import risk.network.NetworkClient;
import risk.protocol.command.HelloCmd;

class RiskProtocol {
    private NetworkClient nc;

    public RiskProtocol(NetworkClient nc) {
        this.nc = nc;
    }

    public void sendHello(Player p) throws IOException {
        Logger.logdebug("Sending Hello to server");
        nc.writeCommand(new HelloCmd(p));
    }

};
