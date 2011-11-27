package risk.game.server;

import risk.game.Player;
import risk.protocol.command.Command;
import risk.protocol.command.GameEndedCmd;

public interface CommandSender {
    public void sendCmd(Command cmd, Player p);
    public void sendCmd(Command cmd, Player p, boolean lastCmd);
    public void sendPlayerJoinedCmd(Player p);
    public void closeConnections();
}
