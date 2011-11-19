package risk.game;

import java.util.Collection;
import java.util.Iterator;

public class Attack {
    private CountryPair countryPair;
    private int attackerDice;
    private int defenderDice;
    
    public Attack(CountryPair countryPair) {
        super();
        this.countryPair = countryPair;
    }

    public int getAttackerDice() {
        return attackerDice;
    }

    public void setAttackerDice(int attackerDice) {
        this.attackerDice = attackerDice;
    }

    public int getDefenderDice() {
        return defenderDice;
    }

    public void setDefenderDice(int defenderDice) {
        this.defenderDice = defenderDice;
    }

    public CountryPair getCountryPair() {
        return countryPair;
    }
    
    public void calcLosses(Collection<Integer> aDice, Collection<Integer> dDice, Integer aLosses, Integer dLosses) {
        Iterator<Integer> aIterator = aDice.iterator();
        Iterator<Integer> dIterator = dDice.iterator();
        aLosses = 0;
        dLosses = 0;
        
        while (aIterator.hasNext() && dIterator.hasNext()) {
            if (aIterator.next() > dIterator.next()) {
                dLosses++;
            } else {
                aLosses++;
            }
        }
    }
}
