package Model.PropositionalLogic;


import javafx.collections.ObservableArray;
import org.sat4j.core.Vec;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.minisat.core.Solver;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a propositional formula. It can either be a conjunction, a disjunction, a negation or a propositional atom.
 */

public abstract class Formula {

    public Boolean isSatisfiable() {
        Vec<VecInt> problem = DimacsConverter.convert(this);

        Solver s = (Solver) SolverFactory.newDefault();
        try {
            s.addAllClauses(problem);
        } catch (ContradictionException e) {
            return false;
        }

        try {
            return s.isSatisfiable();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean isTautology() {
        Negation n = new Negation(this);
        return !n.isSatisfiable();
    }

    public Boolean isInSet(HashSet<Formula> setBase) {
        if (setBase.isEmpty()) {
            return false;
        }

        Formula neg = new Negation(this);

        Formula set = new Conjunction(setBase);

        if (set.isConsistentWith(neg)) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean isConsistentWith(Formula f) {
        Formula conj = new Conjunction(this,f);
        return conj.isSatisfiable();
    }

    //TODO Still checks for individual formula consistency but not for all together. See example in isInSet()
    public Boolean isConsistentWith(HashSet<Formula> set) {
        for(Formula f : set) {
            if (!f.isConsistentWith(this)) {
                return false;
            }
        }
        return true;
    }

    public abstract Boolean isValid();

    public abstract Formula toCNF();

    public abstract ArrayList<Formula> getElements();

    public abstract Integer getValue();

    @Override
    public abstract String toString();
}