package risk.protocol;

import risk.protocol.command.*;

public interface CommandVisitor {
    public void visit(HelloCmd cmd);
    public void visit(PlayerJoinedCmd cmd);
}
