package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;

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

    @Override
    public String toString() {
        return prerequisite + ", " + justification + " > " + consequence;
    }
}