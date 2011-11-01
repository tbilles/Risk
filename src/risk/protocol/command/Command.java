package risk.protocol.command;

import java.io.Serializable;

import risk.protocol.CommandVisitor;

public abstract class Command implements Serializable {
    public static final long serialVersionUID = 1L;
    
    public abstract void accept(CommandVisitor cv);
}
