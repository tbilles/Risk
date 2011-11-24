package risk.game;

import java.io.Serializable;
import java.util.Collection;
import javax.management.RuntimeErrorException;
import risk.protocol.command.Command;

public class SecretMission implements Serializable {
    private static final long serialVersionUID = Command.serialVersionUID;
    public static final int EU_AUS_OTH = 1;
    public static final int EU_SA_OTH = 2;
    public static final int NA_AF = 3;
    public static final int NA_AUS = 4;
    public static final int AS_SA = 5;
    public static final int AS_AF = 6;
    public static final int ANY24 = 7;
    public static final int ANY18W2 = 8;
    public static final int SECRETMISSION_LAST = 9;
    
    private int mission;
    
    public SecretMission(int mission) {
        if (mission < 1 || mission >= SECRETMISSION_LAST) {
            throw new RuntimeException("Invalid secret mission");
        }
        this.mission = mission;
    }
    
    @Override
    public String toString() {
        switch (mission) {
        case EU_AUS_OTH:
            return "Capture Europe, Australia, and one other continent";
        case EU_SA_OTH:
            return "Capture Europe, South Ameria, and one other continent";
        case NA_AF:
            return "Capture North America and Africa";
        case NA_AUS:
            return "Capture North America and Australia";
        case AS_SA:
            return "Capture Asia and South America";
        case AS_AF:
            return "Capture Asia and Africa";
        case ANY24:
            return "Capture 24 territorries";
        case ANY18W2:
            return "Capture 18 territorries and occupy each with two troops";
        }
        throw new RuntimeException("Invalid secret mission");
    }
    
    public boolean hasWon(GameView gv, Player p) {
        switch (mission) {
        case EU_AUS_OTH: {
            boolean eur = gv.getContinent(Continent.EUROPE).capturedByPlayer(p);
            boolean euraus = eur && gv.getContinent(Continent.AUSTRALIA).capturedByPlayer(p);
            boolean eurausoth = euraus &&
                    (gv.getContinent(Continent.NORTHAMERICA).capturedByPlayer(p) ||
                     gv.getContinent(Continent.SOUTHAMERICA).capturedByPlayer(p) ||
                     gv.getContinent(Continent.AFRICA).capturedByPlayer(p) ||
                     gv.getContinent(Continent.ASIA).capturedByPlayer(p));
            if (eurausoth) {
                return true;
            }
            break;
        }
        case EU_SA_OTH: {
            boolean eur = gv.getContinent(Continent.EUROPE).capturedByPlayer(p);
            boolean eursa = eur && gv.getContinent(Continent.SOUTHAMERICA).capturedByPlayer(p);
            boolean eursaoth = eursa &&
                    (gv.getContinent(Continent.NORTHAMERICA).capturedByPlayer(p) ||
                     gv.getContinent(Continent.AUSTRALIA).capturedByPlayer(p) ||
                     gv.getContinent(Continent.AFRICA).capturedByPlayer(p) ||
                     gv.getContinent(Continent.ASIA).capturedByPlayer(p));
            if (eursaoth) {
                return true;
            }
            break;
        }
        case NA_AF: {
            boolean na = gv.getContinent(Continent.NORTHAMERICA).capturedByPlayer(p);
            boolean naaf = na && gv.getContinent(Continent.AFRICA).capturedByPlayer(p);
            if (naaf) {
                return true;
            }
            break;
        }
        case NA_AUS: {
            boolean na = gv.getContinent(Continent.NORTHAMERICA).capturedByPlayer(p);
            boolean naaus = na && gv.getContinent(Continent.AUSTRALIA).capturedByPlayer(p);
            if (naaus) {
                return true;
            }
            break;
        }
        case AS_SA: {
            boolean as = gv.getContinent(Continent.ASIA).capturedByPlayer(p);
            boolean assa = as && gv.getContinent(Continent.SOUTHAMERICA).capturedByPlayer(p);
            if (assa) {
                return true;
            }
            break;
        }
        case AS_AF: {
            boolean as = gv.getContinent(Continent.ASIA).capturedByPlayer(p);
            boolean asaf = as && gv.getContinent(Continent.AFRICA).capturedByPlayer(p);
            if (asaf) {
                return true;
            }
            break;
        }
        case ANY24: {
            int ownedByPlayer = 0;
            Collection<Country> countries = gv.getCountries();
            for (Country c : countries) {
                if (c.getOwner() == p) {
                    ownedByPlayer++;
                }
            }
            if (ownedByPlayer >= 24) {
                return true;
            }
            break;
        }
        case ANY18W2: {
            int ownedByPlayer2 = 0;
            Collection<Country> countries = gv.getCountries();
            for (Country c : countries) {
                if (c.getOwner() == p && c.getTroops() >= 2) {
                    ownedByPlayer2++;
                }
            }
            if (ownedByPlayer2 >= 18) {
                return true;
            }
            break;
        }
        }
        return false;
    }
}
