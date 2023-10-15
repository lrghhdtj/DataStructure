package forth;

public class Linklist<E>{
    Link<E> head;
    public Linklist(){
        head = null;
    }
    public boolean empty(){
        return head == null;
    }
    public void add(E e){
        Link<E> n = new Link<E>(e);
        if(empty()){
            head = n;
        }else {
          n.next = head;
          head = n;
        }
    }
    public int size(){
        Link<E> m = head;
        int t= 1;
        while (m.next != null){
            m = m.next;
            t++;
        }
        return t;
    }

    private Link<E> getindex(int i){
        Link<E> n = head;
        int j =0;
        while (j < i){
            n = n.next;
            j++;
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
    public int getno(Link link, int x) {
        if (x <0 || x > size() -1){
            throw new IllegalArgumentException("无效索引！");
        }
        if((int) link.data == x){
            return 0;
        } else {
            int  i = getno(link.next, x);
            if (i ==-1){
            return -1;
        }else {
                return i +1;
            }
        }
    }





}
