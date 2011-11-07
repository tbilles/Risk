package risk.game.server;

import risk.protocol.command.CommandFromClient;

/**
 * An interface for objects that can execute Commands
 */
public interface CommandExecutor {
    public void QueueCommand(CommandFromClient cmd);
}
