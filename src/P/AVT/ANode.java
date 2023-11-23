package P.AVT;

public class ANode {
    public int data;
    public ANode lchild;
    public ANode rchild;
    public int height;

    public ANode() {
        lchild = rchild = null;
    }

    public ANode(int e) {
        this.data = e;
        height = 0;
    }
}