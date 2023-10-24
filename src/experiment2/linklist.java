package experiment2;


public class linklist<E> {
    link<E> head;
    public linklist(){
        head = null;
    }
    public boolean empty(){
        return head == null;
    }
    public void add(E e){
        link<E> n = new link<E>(e);
        if(empty()){
            head = n;
        }else {
            n.next = head;
            head = n;
        }
    }
    public int size(){
        link<E> m = head;
        int t= 1;
        while (m.next != null){
            m = m.next;
            t++;
        }
        return t;
    }

    private link<E> getindex(int i){
        link<E> n = head;
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
            link<E> n = getindex(i);
            return (E) n.data;
        }
    }
}
