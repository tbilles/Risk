package risk.game.server;

import risk.game.Player;
import risk.protocol.command.Command;

public interface CommandExecutor {
    public void QueueCommand(Command cmd, Player player);
}
