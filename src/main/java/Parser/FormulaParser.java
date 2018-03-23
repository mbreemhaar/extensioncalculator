package Parser;

import Model.PropositionalLogic.*;

public class FormulaParser {
    private int pos = 0;
    private String string;

    public FormulaParser(String string) {
        this.string = string;
    }

    private Character nextChar() {
        if (pos >= string.length()) {
            return null;
        } else if (string.charAt(pos) == ' ') {
            pos++;
            return nextChar();
        } else {
            return string.charAt(pos++);
        }
    }

    private Node buildTree() {
        Node currentNode = new Node();
        Character next = nextChar();

        while(next != null) {
            if (next == '(') {
                currentNode = currentNode.getLeftChild();
            }

            if (next >= 'a' && next <= 'z') {
                currentNode.setValue(next);
            }

            if (next == '&' || next == '|') {
                currentNode = currentNode.getParent();
                while (currentNode.getValue() != null) {
                    currentNode = currentNode.getParent();
                }
                currentNode.setValue(next);
                currentNode = currentNode.getRightChild();
            }

            if (next == '!') {
                currentNode.setValue(next);
                currentNode = currentNode.getLeftChild();
            }

            if (next == ')') {
                currentNode = currentNode.getParent();
            }

            next = nextChar();

        }

        while (currentNode.hasParent()) {
            currentNode = currentNode.getParent();
        }

        return currentNode;
    }

    private Formula buildFormula(Node node) {
        if (node.getValue() >= 'a' && node.getValue() <= 'z') {
            return new Atom(node.getValue());
        }

        if (node.getValue() == '!') {
            Node child = node.getLeftChild();
            return new Negation(buildFormula(child));
        }

        if (node.getValue() == '&') {
            Node leftChild = node.getLeftChild();
            Node rightChild = node.getRightChild();

            return new Conjunction(buildFormula(leftChild),buildFormula(rightChild));
        }

        if (node.getValue() == '|') {
            Node leftChild = node.getLeftChild();
            Node rightChild = node.getRightChild();

            return new Disjunction(buildFormula(leftChild),buildFormula(rightChild));
        }

        return null;
    }

    public Formula parse() {
        Node tree = buildTree();
        return buildFormula(tree);
    }

}