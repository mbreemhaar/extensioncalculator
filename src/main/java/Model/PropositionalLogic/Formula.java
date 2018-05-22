package Model.PropositionalLogic;


import org.sat4j.core.Vec;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.minisat.core.Solver;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import java.util.ArrayList;

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

    public abstract Formula toCNF();

    public abstract ArrayList<Formula> getElements();

    public abstract Integer getValue();

    @Override
    public abstract String toString();
}