package experiment4;

public class HTNode<E> {
    public E data;
    public tLinkList firstchild;
    public HTNode(){
        firstchild = null;
    }
    public HTNode(E e){
        data = e;
        firstchild = null;
    }


}
