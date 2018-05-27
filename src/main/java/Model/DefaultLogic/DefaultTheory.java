package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * A default theory consists of a finite set of axioms and a finite set of defaults.
 */

public class DefaultTheory {
    private Set<Formula> axioms = new HashSet<>();
    private Set<Default> defaults = new HashSet<>();

    public static DefaultTheory currentTheory;

    public DefaultTheory() {
        currentTheory = this;
    }

    public void add(Formula f) {
        axioms.add(f);
    }

    public void remove(Formula f) {
        axioms.remove(f);
    }

    public void add(Default d) {
        defaults.add(d);
    }

    public void remove(Default d) {
        defaults.remove(d);
    }
}
