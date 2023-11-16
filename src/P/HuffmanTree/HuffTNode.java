package P.HuffmanTree;

public class HuffTNode {
    char data;
    double weight;
    public HuffTNode parent;
    HuffTNode lchild;
    HuffTNode rchild;
    boolean flag;
    public HuffTNode(){
        parent = null;
        lchild = null;
        rchild = null;
    }
    public double getWeight(){
        return weight;
    }
}
