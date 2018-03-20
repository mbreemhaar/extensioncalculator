package Model.PropositionalLogic;

public class Atom extends Formula {
    private String name;

    public Atom(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
