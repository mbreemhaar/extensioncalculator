package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;

import java.util.Set;

/**
 * A default theory consists of a finite set of axioms and a finite set of defaults.
 */

public class DefaultTheory {
    private Set<Formula> axioms;
    private Set<Formula> defaults;
}
