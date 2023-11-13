package experiment2;

import P.LinkNode;
import P.Linklist;

public class task {
    public static void main(String[] args) {
        Linklist list = new Linklist<Integer>();
        list.add(1);list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.print();
        LinkNode n =deleterepeat(list.head);
        while (n != null) {
            System.out.print(n.data+" ");
            n = n.next;
        }


    }
    public static LinkNode deleterepeat(LinkNode head){
        int t = 1;
        LinkNode tmphead = new LinkNode<>();
        tmphead.next = head;
        LinkNode n = head , m = head.next,s = tmphead;
        if(n == null || m == null){
            return head;
        }
        while (m != null){
            if(n.data == m.data){
                t++;
                m = m.next;
            }else {
                if(t >1){
                    if(n == head){
                        head =m;
                    }
                   n = s;
                   s.next = m;
                   n = n.next;
                   m = m.next;
                    t = 1;
                }else {
                    n = n.next;
                    m = m.next;
                    s =s.next;
                }

            }
        }

        if(m == null && t >1){
            s.next =null;
        }

        return head;
    }

}
