package P.SonTree;

public class CTNode <E>{
     E child;
     CTNode <E> next;
    public CTNode(){
        next = null;
    }
    public CTNode(E e){
        child = e;
        next = null;
    }

}
