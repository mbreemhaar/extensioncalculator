package model.dlogic;

import model.plogic.Formula;

import java.util.HashSet;
import java.util.Set;

/**
 * A default consists of a prerequisite, a finite set of justifications and a consequence.
 */

public class Default {
    private Formula prerequisite;
    private Set<Formula> justification;
    private Formula consequence;

    public Default(Formula prerequisite, Set<Formula> justification, Formula consequence) {
        this.prerequisite = prerequisite;
        this.justification = justification;
        this.consequence = consequence;
    }

    public Boolean isApplicable(HashSet<Formula> inSetBase) {
        if (!Formula.isConsistent(inSetBase)) {
            return false;
        }

        if ((prerequisite == null || prerequisite.isInSet(inSetBase) || prerequisite.isTautology())) {
            for(Formula f : justification) {
                if (!f.isConsistentWith(inSetBase)) {
                    return false;
                }
            }
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        if (prerequisite != null) {
            return prerequisite + " : " + justification + " / " + consequence;
        } else {
            return "true : " + justification + " / " + consequence;
        }
    }

    public Formula getPrerequisite() {
        return prerequisite;
    }

    public Set<Formula> getJustification() {
        return justification;
    }

    public Formula getConsequence() {
        return consequence;
    }
}