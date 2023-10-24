package experiment2;
public class link <E>{
    E data;
    link<E> next;

    public link() {
        next = null;
    }
    public link(E e){
        data= e;
        next = null;
    }
}
