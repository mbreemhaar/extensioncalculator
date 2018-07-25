package model.plogic;


import java.util.ArrayList;

/**
 * Represents a propositional atom as in simple propositional logic. It is represented by a single character and can be
 * a logical formula by itself.
 */

public class Atom extends Formula {

    private final String name;
    private final Integer value;

    public Atom(String name) {
        this.name = name;
        this.value = makeValue();
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

    private Integer makeValue() {
        double value = 0;
        for(int i = 0; i < name.length(); i++) {
            value += (name.charAt(i) - 96) * Math.pow(27,i);
        }
        return (int)value;
    }

    public Integer getValue() {
        return value;
    }
}
