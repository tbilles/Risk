package risk.protocol.command;

import risk.game.SecretMission;
import risk.protocol.CommandVisitor;

public class SecretMissionCmd extends Command {
    private static final long serialVersionUID = Command.serialVersionUID;
    private SecretMission secretMission;
    
    public SecretMissionCmd(SecretMission secretMission) {
        super();
        this.secretMission = secretMission;
    }

    @Override
    public void accept(CommandVisitor cv) {
        cv.visit(this);
    }

    public SecretMission getSecretMission() {
        return secretMission;
    }
}
