package experiment1;



public class Linklist <E>{
    Link<E> head;
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
    public boolean empty(){
        return head.next == null;
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

    public void print(){
        Link<E> n = head.next;
        while (n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
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

    public int indexof(E e){
        Link<E> n = head.next;
        int i = 0;
        while (n != null){
            if (n.data != e){
                i++;
                n =n.next;
            }else {
                return i;
            }
        }
        return -1;
    }
    public void insert(E e,int i){
        if (i <0 || i > size() -1){
            throw new IllegalArgumentException("无效索引！");
        }else {
            Link<E> m =getindex(i-1);
            Link<E> n = new Link<>(e);
            n.next = m.next;
            m.next = n;
        }
    }
    public void delete(int i){
        if (i <0 || i > size() -1){
            throw new IllegalArgumentException("无效索引！");
        }else {
            Link<E> m =getindex(i-1);
            m.next =m.next.next;

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
public void release(){
        head.next = null;
}




}
