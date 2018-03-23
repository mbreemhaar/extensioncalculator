package Parser;

public class Node {
    private Node leftChild, rightChild, parent;
    private Character value;

    public Node() {}

    public Node(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        if (leftChild == null) {
            leftChild = new Node(this);
        }
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        if (rightChild == null) {
            rightChild = new Node(this);
        }
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Boolean hasParent() {
        if (parent == null) {
            return false;
        } else {
            return true;
        }
    }

    public Node getParent() {
        if (parent == null) {
            parent = new Node();
            parent.setLeftChild(this);
        }
        return parent;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }
}
