package Model.DefaultLogic;

import Model.PropositionalLogic.Formula;
import Model.PropositionalLogic.Negation;

import java.util.HashSet;

public class Extension {

    private HashSet<Default> defaults = new HashSet<>();
    private HashSet<Formula> inSetBase = new HashSet<>();
    private HashSet<Formula> outSetBase = new HashSet<>();
    private HashSet<Extension> children = new HashSet<>();

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

        children.add(new Extension(newDefaults,newInSetBase,newOutSetBase));
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
        return inSetBase.toString() + "\n" + children.toString();
    }
}