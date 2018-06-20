package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;

import java.util.HashSet;
import java.util.Set;

/**
 * A default consists of a prerequisite, a finite set of justifications and a consequence.
 */

public class Default {
    private Formula prerequisite;
    private Formula justification;
    private Formula consequence;

    public Default(Formula prerequisite, Formula justification, Formula consequence) {
        this.prerequisite = prerequisite;
        this.justification = justification;
        this.consequence = consequence;
    }

    public Boolean isApplicable(HashSet<Formula> inSetBase) {
        if ((prerequisite.isInSet(inSetBase) || prerequisite.isTautology()) && justification.isConsistentWith(inSetBase)) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return prerequisite + " : " + justification + " / " + consequence;
    }

    public Formula getPrerequisite() {
        return prerequisite;
    }

    public Formula getJustification() {
        return justification;
    }

    public Formula getConsequence() {
        return consequence;
    }
}