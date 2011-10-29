package risk.protocol;

import risk.common.Logger;
import risk.network.NetworkClient;
import risk.protocol.command.*;

public class ServerProtocolHandler {
    private RiskProtocol proto;

    public ServerProtocolHandler(NetworkClient nc) {
        proto = new RiskProtocol(nc);
    }

    public void onCommand(Command cmd) {
        ServerCommandVisitor scv = new ServerCommandVisitor(this);
        cmd.accept(scv);
    }
    
    public void onHello(HelloCmd cmd) {
        Logger.logdebug("Got hello after visit!!");
    }
}