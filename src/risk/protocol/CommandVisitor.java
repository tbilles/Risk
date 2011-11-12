package risk.protocol;

import risk.protocol.command.*;

public interface CommandVisitor {
    public void visit(HelloCmd cmd);
    public void visit(PlayerJoinedCmd cmd);
    public void visit(GameStartedCmd cmd);
    public void visit(NewTurnCmd cmd);
    public void visit(CountyInitCmd cmd);
    public void visit(GameEndedCmd cmd);
}
