package experiment2;
public class linknode<E>{
    E data;
    linknode<E> next;

    public linknode() {
        next = null;
    }
    public linknode(E e){
        data= e;
        next = null;
    }
}
