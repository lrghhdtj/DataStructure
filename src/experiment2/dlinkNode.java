package experiment2;

public class dlinkNode <E>{
    E data;
    dlinkNode<E> prior;
    dlinkNode<E> next;
    public dlinkNode(){
        prior = null;
        next = null;
    }
    public dlinkNode(E e){
        data = e;
        prior = null;
        next = null;
    }

}
