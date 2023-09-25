package second;

public class Linklist <E>{
    Link <E>head;
    public Linklist(){
        head = new Link<E>();
        head.next = null;
    }
    public void Creat(E[] e){
        Link<E> a,b;
        b = head;
        for (int i = 0; i <e.length;i++){
        a = new Link<>(e[i]);
        b.next = a;
        b =a;
        }
        b.next =null;
    }
    public void add(E e){
        Link<E> n = new Link<E>(e);
        Link<E> m = head;
        while (m.next != null){
            m = m.next;
        }
            m.next =n;
    }
    public int size(){
        Link<E> m = head;
        int t= 0;
        while (m.next != null){
            m = m.next;
            t++;
        }
        return t;
    }
    private Link<E> getindex(int i){
        Link<E> n = head;
        int j =-1;
        while (j <i){
            j++;
            n =n.next;
        }
        return n;
    }
    public E get(int i){
        if (i <0 || i > size() -1){
            throw new IllegalArgumentException("无效索引！");
        }else {
            Link<E> n = getindex(i);
            return (E) n.data;
        }
    }
    public void set(int i ,E e){
    if (i <0 || i > size() -1){
        throw new IllegalArgumentException("无效索引！");
    }else {
        Link<E> link = getindex(i);
        link.data =  e;
    }
}





}
