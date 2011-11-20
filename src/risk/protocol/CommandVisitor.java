package risk.protocol;

import risk.protocol.command.*;

public interface CommandVisitor {
    public void visit(HelloCmd cmd);
    public void visit(PlayerJoinedCmd cmd);
    public void visit(GameStartedCmd cmd);
    public void visit(NextRoundCmd cmd);
    public void visit(CountyInitCmd cmd);
    public void visit(GameEndedCmd cmd);
    public void visit(PlaceReinforcementCmd cmd);
    public void visit(NextPhaseCmd cmd);
    public void visit(NextPlayerCmd cmd);
    public void visit(RegroupCmd cmd);
    public void visit(AttackStartCmd cmd);
    public void visit(AttackSetADiceCmd cmd);
    public void visit(AttackSetDDiceCmd cmd);
    public void visit(AttackRoundResultCmd cmd);
    public void visit(AttackRetreatCmd cmd);
    public void visit(EndTurnCmd cmd);
    public void visit(ErrorCmd cmd);
}
