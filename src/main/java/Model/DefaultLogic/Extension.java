package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;
import Model.PropositionalLogic.Negation;

import java.util.ArrayList;
import java.util.HashSet;

public class Extension {

    private HashSet<Default> remainingDefaults;
    private HashSet<Formula> inSetBase;
    private HashSet<Formula> outSetBase;
    private HashSet<Extension> children = new HashSet<>();
    private ArrayList<Default> process = new ArrayList<>();

    public Extension(HashSet<Default> remainingDefaults, HashSet<Formula> inSetBase, HashSet<Formula> outSetBase, ArrayList<Default> process) {
        this.remainingDefaults = remainingDefaults;
        this.inSetBase = inSetBase;
        this.outSetBase = outSetBase;
        this.process = process;
    }

    private void applyDefault(Default d) {
        assert(d.isApplicable(inSetBase));

        HashSet<Default> newDefaults = (HashSet<Default>) remainingDefaults.clone();
        newDefaults.remove(d);

        HashSet<Formula> newInSetBase = (HashSet<Formula>)inSetBase.clone();
        Formula consequence = d.getConsequence();
        if (!consequence.isInSet(newInSetBase)) {
            newInSetBase.add(consequence);
        }

        HashSet<Formula> newOutSetBase = (HashSet<Formula>)outSetBase.clone();

        for(Formula f : d.getJustification()) {
            Negation neg = new Negation(f);
            if (!neg.isInSet(newOutSetBase)) {
                newOutSetBase.add(new Negation(f));
            }
        }

        ArrayList<Default> newProcess = (ArrayList<Default>)process.clone();
        newProcess.add(d);

        Extension newExtension = new Extension(newDefaults,newInSetBase,newOutSetBase,newProcess);
        children.add(newExtension);
    }

    public void applyAllDefaults() {
        for(Default d : remainingDefaults) {
            if(d.isApplicable(inSetBase)) {
                applyDefault(d);
            }
        }
    }

    protected void buildProcessTree() {
        applyAllDefaults();

        for (Extension c : children) {
            c.buildProcessTree();
        }
    }

    public boolean isClosed() {
        for(Default d : remainingDefaults) {
            if (d.isApplicable(inSetBase)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSuccessful() {
        if (!Formula.isConsistent(inSetBase)) {
            return false;
        }

        if (inSetBase.isEmpty() || outSetBase.isEmpty()) {
            return true;
        }

        for (Formula f : outSetBase) {
            if (f.isInSet(inSetBase)) {
                return false;
            }
        }

        return true;

    }

    @Override
    public String toString() {
        if (process.size() != 0) {
            return process.get(process.size()-1).toString() + "\n" + inSetBase.toString();
        } else {
            return inSetBase.toString();
        }
    }

    public HashSet<Extension> getChildren() {
        return children;
    }

    public String getDetailsString() {
        StringBuilder s = new StringBuilder();
        s.append("Process: " + process + "\n");
        if (isClosed()) {
            s.append("Closed: yes\n");
        } else {
            s.append("Closed: no\n");
        }

        if (isSuccessful()) {
            s.append("Successful: yes\n");
        } else {
            s.append("Successful: no\n");
        }

        s.append("In-set: " + inSetBase + "\n");
        s.append("Out-set: " + outSetBase + "\n");
        return s.toString();
    }
}