public class Node {

    int value;
    Node left;
    Node right;
    Node parent;
    int height;

    Node(int v) {
        this.value = v;
        this.height = 0;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean hasOnlyLeftChild() {
        return (this.left != null && this.right == null);
    }

    public boolean hasOnlyRightChild() {
        return (this.left == null && this.right != null);
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

}
