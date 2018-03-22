package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;

import java.util.Set;

/**
 * A default consists of a prerequisite, a finite set of justifications and a consequence.
 */

public class Default {
    private Formula prerequisite;
    private Set<Formula> justifications;
    private Formula consequence;
}
