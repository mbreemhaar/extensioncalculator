package Model.PropositionalLogic;

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
    public String toString() {
        return "(" + clause1 + " & " + clause2 + ")";
    }
}
