package risk.protocol;

import risk.common.Logger;
import risk.protocol.command.HelloCmd;

public class ServerCommandVisitor implements CommandVisitor {
    private ServerProtocolHandler sph;
    
    public ServerCommandVisitor(ServerProtocolHandler sph) {
        this.sph = sph;
    }

    @Override
    public void visit(HelloCmd cmd) {
        Logger.logdebug("Got HelloCmd");
        sph.onHello(cmd);
    }
    
    
}
