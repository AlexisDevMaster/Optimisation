package branchandbound;

public class Node {

    private float borneSup;
    private float cout;
    private Node left;
    private Node right;

    public Node(float borneSup, float cout){
        this.borneSup = borneSup;
        this.cout = cout;
        this.left = null;
        this.right = null;
    }

    public Node(float borneSup, float cout, Node left, Node right){
        this.borneSup = borneSup;
        this.cout = cout;
        this.left = left;
        this.right = right;

    }

    public float getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public float getBorneSup() {
        return borneSup;
    }

    public void setBorneSup(int borneSup) {
        this.borneSup = borneSup;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
