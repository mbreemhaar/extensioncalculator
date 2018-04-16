package Model.PropositionalLogic;

import java.util.ArrayList;

/**
 * Represents a conjunction as in propositional logic. Connects two propositional formulas and is also a formula itself.
 */

public class Conjunction extends Formula {
    private Formula clause1;
    private Formula clause2;

    public Conjunction(Formula clause1, Formula clause2) {
        this.clause1 = clause1;
        this.clause2 = clause2;
    }

    @Override
    public ArrayList<Formula> getElements() {
        ArrayList<Formula> list = new ArrayList<Formula>();
        list.add(clause1);
        list.add(clause2);
        return list;
    }

    @Override
    public Formula toCNF() {
        return new Conjunction(clause1.toCNF(),clause2.toCNF());
    }

    @Override
    public String toString() {
        return "(" + clause1 + " & " + clause2 + ")";
    }
}
