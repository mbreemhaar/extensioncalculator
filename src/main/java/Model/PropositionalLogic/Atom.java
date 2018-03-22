package Model.PropositionalLogic;

/**
 * Represents a propositional atom as in simple propositional logic. It is represented by a single character and can be
 * a logical formula by itself.
 */

public class Atom extends Formula {

    private Character name;

    public Atom(Character name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Character.toString(name);
    }
}
