package Model.PropositionalLogic;

/**
 * Represents a negation as in propositional logic. It negates a single formula and also is a formula itself.
 */

public class Negation extends Formula {
    private Formula formula;

    public Negation(Formula formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return "!(" + formula + ")";
    }
}
