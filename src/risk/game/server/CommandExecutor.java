package risk.game.server;

import risk.game.Player;
import risk.protocol.command.Command;

/**
 * An interface for objects that can execute Commands
 */
public interface CommandExecutor {
    public void QueueCommand(Command cmd, Player player);
}
