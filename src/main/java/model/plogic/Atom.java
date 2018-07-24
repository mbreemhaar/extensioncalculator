package model.plogic;


import java.util.ArrayList;

/**
 * Represents a propositional atom as in simple propositional logic. It is represented by a single character and can be
 * a logical formula by itself.
 */

public class Atom extends Formula {

    private String name;

    public Atom(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<Formula> getElements() {
        ArrayList<Formula> list = new ArrayList<Formula>();
        list.add(this);
        return list;
    }

    @Override
    public Boolean isValid() {
        return name != null;
    }

    @Override
    public Formula toCNF() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer getValue() {
        double value = 0;
        for(int i = 0; i < name.length(); i++) {
            value += (name.charAt(i) - 97) * Math.pow(26,i);
        }
        return (int)value;
    }
}
