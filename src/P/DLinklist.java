package P;


import P.DLinkNode;

public class DLinklist<E>{
    DLinkNode<E> head;
    public DLinklist(){
        head = new DLinkNode<E>();
        head.prior = null;
        head.next =null;
    }
    public void add(E e){
        DLinkNode<E> n = new DLinkNode<>(e);
        DLinkNode<E> m = head;
        while (m.next != null){
            m = m.next;
        }
        m.next =n;
        n.prior = m;
        n.next = null;
    }

    public void print(){
        DLinkNode n = head.next;
        while (n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public int size(){
        int len = 0;
        DLinkNode n = head.next;
        while (n != null){
            len++;
            n = n.next;
        }
        return len;
    }
    public boolean empty(){
        return head.next == null;
    }
    private DLinkNode<E> getindex(int i){
        DLinkNode<E> n = head;
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
            DLinkNode<E> n = getindex(i);
            return (E) n.data;
        }
    }
    public int indexof(E e){
        DLinkNode<E> n = head.next;
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
            DLinkNode<E> m =getindex(i-1);
            DLinkNode<E> n = new DLinkNode<>(e);
            n.next = m.next;
            m.next.prior = n;
            m.next = n;
            n.prior = m;
        }
    }
    public void delete(int i){
        if (i <0 || i > size() -1){
            throw new IllegalArgumentException("无效索引！");
        }else {
            DLinkNode<E> m =getindex(i-1);
            m.next =m.next.next;
            m.next.next.prior = m;

        }
    }
    public void release(){
        head.next = null;
    }
}
