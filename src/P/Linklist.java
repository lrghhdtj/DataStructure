package P;

import P.LinkNode;

public class Linklist <E>{
    public LinkNode<E> head;
    public Linklist(){
        head = new LinkNode<E>();
        head.next = null;
    }
    public void Creat(E[] e){
        LinkNode<E> a,b;
        b = head;
        for (int i = 0; i <e.length;i++){
        a = new LinkNode<>(e[i]);
        b.next = a;
        b =a;
        }
        b.next =null;
    }
    public void add(E e){
        LinkNode<E> n = new LinkNode<E>(e);
        LinkNode<E> m = head;
        while (m.next != null){
            m = m.next;
        }
            m.next =n;
    }
    public int size(){
        LinkNode<E> m = head;
        int t= 0;
        while (m.next != null){
            m = m.next;
            t++;
        }
        return t;
    }
    private LinkNode<E> getindex(int i){
        LinkNode<E> n = head;
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
            LinkNode<E> n = getindex(i);
            return (E) n.data;
        }
    }
    public void set(int i ,E e){
    if (i <0 || i > size() -1){
        throw new IllegalArgumentException("无效索引！");
    }else {
        LinkNode<E> linkNode = getindex(i);
        linkNode.data =  e;
    }
}


    public int getno(LinkNode link, int x) {
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
    public void delete(int i){
        if (i <0 || i > size() -1){
            throw new IllegalArgumentException("无效索引！");
        }else {
            LinkNode<E> m =getindex(i-1);
            m.next =m.next.next;

        }
    }
    public void print(){
        LinkNode n = head;
        while (n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public boolean empty(){
        return head.next == null;
    }

    public void release(){
        head.next = null;
    }


    public void insert(E e,int i){
        if (i <0 || i > size() -1){
            throw new IllegalArgumentException("无效索引！");
        }else {
            LinkNode<E> m =getindex(i-1);
            LinkNode<E> n = new LinkNode<>(e);
            n.next = m.next;
            m.next = n;
        }
    }

    public int indexof(E e){
        LinkNode<E> n = head.next;
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
}
