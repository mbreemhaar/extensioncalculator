package Model.PropositionalLogic;


import java.util.ArrayList;

/**
 * Represents a propositional formula. It can either be a conjunction, a disjunction, a negation or a propositional atom.
 */

public abstract class Formula {
    public abstract Formula toCNF();

    public abstract ArrayList<Formula> getElements();

    @Override
    public abstract String toString();
}