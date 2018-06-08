package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;
import Model.PropositionalLogic.Negation;

import java.util.HashSet;

public class Extension {

    private HashSet<Default> defaults;
    private HashSet<Formula> inSetBase;
    private HashSet<Formula> outSetBase;
    private HashSet<Extension> children = new HashSet<>();

    private Default appliedDefault = null;

    public Extension(HashSet<Default> defaults, HashSet<Formula> inSetBase, HashSet<Formula> outSetBase) {
        this.defaults = defaults;
        this.inSetBase = inSetBase;
        this.outSetBase = outSetBase;
    }

    private void applyDefault(Default d) {
        assert(d.isApplicable(inSetBase));

        HashSet<Default> newDefaults = (HashSet<Default>) defaults.clone();
        newDefaults.remove(d);

        HashSet<Formula> newInSetBase = (HashSet<Formula>)inSetBase.clone();
        newInSetBase.add(d.getConsequence());

        HashSet<Formula> newOutSetBase = (HashSet<Formula>)outSetBase.clone();
        newOutSetBase.add(new Negation(d.getJustification()));

        Extension newExtension = new Extension(newDefaults,newInSetBase,newOutSetBase);
        newExtension.appliedDefault = d;
        children.add(newExtension);
    }

    public void applyAllDefaults() {
        for(Default d : defaults) {
            if(d.isApplicable(inSetBase)) {
                applyDefault(d);
            }
        }
    }

    protected void buildProcessTree() {
        applyAllDefaults();

        if (children.size() == 0) {
            System.out.println(inSetBase);
        } else {
            System.out.println(children.size());
        }

        for (Extension c : children) {
            c.buildProcessTree();
        }
    }

    @Override
    public String toString() {
        if (appliedDefault != null) {
            return appliedDefault.toString() + "\n" + inSetBase.toString();
        } else {
            return inSetBase.toString();
        }
    }

    public HashSet<Extension> getChildren() {
        return children;
    }
}