package risk.protocol;

import java.io.IOException;

import risk.common.Logger;
import risk.network.QueuedSender;
import risk.protocol.command.HelloCmd;

class RiskProtocol {
    private QueuedSender sender;

    public RiskProtocol(QueuedSender sender) {
        this.sender = sender;
    }

    public void sendHello(String name) throws IOException {
        Logger.logdebug("Sending Hello to server");
        sender.queueForSend(new HelloCmd(name));
    }
};
