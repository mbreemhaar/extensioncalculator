package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;
import Utility.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A default theory consists of a finite set of axioms and a finite set of defaults.
 */

public class DefaultTheory {
    private ObservableList<Formula> axioms = Utility.mainController.getAxiomList();
    private ObservableList<Default> defaults = Utility.mainController.getDefaultList();

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

    public Extension buildProcessTree() {
        Extension top = new Extension(new HashSet<>(new ArrayList<>(defaults)), new HashSet<>(new ArrayList<>(axioms)), new HashSet<>(), new ArrayList<>());
        top.buildProcessTree();
        return top;
    }
}
