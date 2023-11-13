package P;

public class DLinkNode<E>{
    E data;
    DLinkNode<E> prior;
    DLinkNode<E> next;
    public DLinkNode(){
        prior = null;
        next = null;
    }
    public DLinkNode(E e){
        data = e;
        prior = null;
        next = null;
    }

}
