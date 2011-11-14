package risk.game.server;

import risk.game.Player;
import risk.protocol.command.Command;

public interface CommandSender {
    public void sendCmd(Command cmd, Player p);
    public void sendPlayerJoinedCmd(Player p);
}
