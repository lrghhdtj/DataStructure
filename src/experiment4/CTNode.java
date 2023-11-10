package experiment4;

public class CTNode <E>{
    public E child;
    public CTNode next;
    public CTNode(){
        next = null;
    }
    public CTNode(E e){
        child = e;
        next = null;
    }

}
