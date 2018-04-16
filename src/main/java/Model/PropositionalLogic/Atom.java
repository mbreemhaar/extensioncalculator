package Model.PropositionalLogic;


import java.util.ArrayList;

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
    public ArrayList<Formula> getElements() {
        ArrayList<Formula> list = new ArrayList<Formula>();
        list.add(this);
        return list;
    }

    @Override
    public Formula toCNF() {
        return this;
    }

    @Override
    public String toString() {
        return Character.toString(name);
    }
}
