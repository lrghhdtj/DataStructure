package experiment2;

import experiment1.Link;

public class dlinklist <E>{
    dlinkNode <E> head;
    public dlinklist(){
        head = new dlinkNode<E>();
        head.prior = null;
        head.next =null;
    }
    public void add(E e){
        dlinkNode m = new dlinkNode<>(e);
        dlinkNode n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = m;
        m.prior = n;
        m.next = null;
    }

    public void print(){
        dlinkNode n = head.next;
        while (n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public int size(){
        int len = 0;
        dlinkNode n = head.next;
        while (n != null){
            len++;
            n = n.next;
        }
        return len;
    }
    public boolean empty(){
        return head.next == null;
    }
    private dlinkNode<E> getindex(int i){
        dlinkNode<E> n = head;
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
            dlinkNode<E> n = getindex(i);
            return (E) n.data;
        }
    }
    public int indexof(E e){
        dlinkNode<E> n = head.next;
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
            dlinkNode<E> m =getindex(i-1);
            dlinkNode<E> n = new dlinkNode<>(e);
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
            dlinkNode<E> m =getindex(i-1);
            m.next =m.next.next;
            m.next.next.prior = m;

        }
    }
    public void release(){
        head.next = null;
    }
}
