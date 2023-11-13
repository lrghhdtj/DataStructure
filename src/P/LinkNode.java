package P;

 public class LinkNode<E>{
    public E data;
    public LinkNode<E> next;

    public LinkNode() {
        next = null;
    }
    public LinkNode(E e){
        data= e;
        next = null;
    }
}
