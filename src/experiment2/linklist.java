package experiment2;

public class linklist<E> {
    linknode<E> head;
    public linklist(){
        head = null;
    }
    public boolean empty(){
        return head == null;
    }
    public void add(E e){
        linknode<E> n = new linknode<>(e);
        linknode<E> m = head;
        if(empty()){
            head = n;
        }else {
           while (m.next !=null){
               m = m.next;
           }
           m.next = n;
           n.next = null;
        }
    }
    public int size(){
        linknode<E> m = head;
        int t= 1;
        while (m.next != null){
            m = m.next;
            t++;
        }
        return t;
    }

    private linknode<E> getindex(int i){
        linknode<E> n = head;
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
            linknode<E> n = getindex(i);
            return (E) n.data;
        }
    }
    public void print(){
        linknode n = head;
        while (n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
/*    public link deleterepeat(link head){
        int t = 1,seat = -1;
        link <E> n = head , m = head.next,s;
        if(n == null || m == null){
            return head;
        }
        while (m != null){
            if(n.data == m.data){
                t++;
                m = m.next;
            }else {
                if (t >1){
                    if(n == head){
                        n = m;
                        m = m.next;
                        head = n;
                        seat = -2;
                    }else {
                        s = getindex(seat);
                        n = s;
                        n.next = m;
                        n = n.next;
                        m = m.next;
                        seat -= t;
                    }
                    t = 1;
                }else {
                    n = n.next;
                    m = m.next;
                }
                    seat++;
            }
        }

        return n;
    }*/

}
