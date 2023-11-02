package five;

public class BTNode<E>{
    E data;
    BTNode lchild;
    BTNode rchild;
    public BTNode(){
        rchild = lchild = null;
    }
    public BTNode(E e){
        data = e;
        rchild = lchild = null;
    }
}