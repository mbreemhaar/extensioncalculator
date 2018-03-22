package Model.PropositionalLogic;

public class Conjunction extends Formula {
    private Formula clause1;
    private Formula clause2;

    public Conjunction(Formula clause1, Formula clause2) {
        this.clause1 = clause1;
        this.clause2 = clause2;
    }

    @Override
    public String toString() {
        return "(" + clause1 + " & " + clause2 + ")";
    }
}
