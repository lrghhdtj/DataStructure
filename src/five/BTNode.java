package five;

public class BTNode<E>{
    public E data;
    public BTNode lchild;
    public BTNode rchild;
    public BTNode(){
        rchild = lchild = null;
    }
    public BTNode(E e){
        data = e;
        rchild = lchild = null;
    }
}