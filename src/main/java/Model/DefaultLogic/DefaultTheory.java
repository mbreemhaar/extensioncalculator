package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;
import Utility.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashSet;

/**
 * A default theory consists of a finite set of axioms and a finite set of defaults.
 */

public class DefaultTheory {
    private HashSet<Formula> axioms = new HashSet<>();
    private HashSet<Default> defaults = new HashSet<>();

    public DefaultTheory() {
        Utility.theory = this;
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

    public HashSet<Formula> getAxioms() {
        return axioms;
    }

    public HashSet<Default> getDefaults() {
        return defaults;
    }
}
