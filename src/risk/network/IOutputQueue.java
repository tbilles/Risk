package risk.network;

import risk.protocol.command.Command;

public interface IOutputQueue {
    public void queueForSend(Command cmd);
}
