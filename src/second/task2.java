package second;

public class task2 {
   //有两个集合采用整数单链表A、B存储，设计一个算法求两个集合的差集C，C仍然用单链表存储。并给出算法的时间和空间复杂度。例如A=（1，3，2），B=（5，1，4，2），差集C=（3）。
    public static void main(String[] args) {
        Integer [] a = {1,3,2};
        Linklist<Integer> A = new Linklist<>();
        Integer [] b = {5,1,4,2};
        Linklist<Integer> B = new Linklist<>();
        A.Creat(a);
        B.Creat(b);
        System.out.print("A:");
        for (int i = 0; i <A.size() ; i++) {
            System.out.print(A.get(i)+" ");
        }
        System.out.println();
        System.out.print("B:");
        for (int i = 0; i <B.size() ; i++) {
            System.out.print(B.get(i)+" ");
        }
        Linklist<Integer> C = different(A,B);
        System.out.println();
        System.out.print("差集C:");
        for (int i = 0; i <C.size() ; i++) {
            System.out.print(C.get(i)+" ");
        }
       /* //----------------------------------
        System.out.println();
        System.out.print("A:");
        for (int i = 0; i <A.size() ; i++) {
            System.out.print(A.get(i)+" ");
        }
        System.out.println();
        System.out.print("B:");
        for (int i = 0; i <B.size() ; i++) {
            System.out.print(B.get(i)+" ");
        }*/
    }
        public  static Linklist<Integer> different(Linklist<Integer> a, Linklist<Integer> b) {
            Linklist<Integer> c = new Linklist<>();
            Link<Integer> i = a.head.next;
            Link<Integer> j = b.head.next;
            Link<Integer> p = c.head;
            Link<Integer> q;
            while (i.next != null) {
                int t = 0;
                while (j.next != null) {
                    if (i.data == j.data) {
                        t++;
                        break;
                    }
                    j = j.next;
                }
                if (t == 0) {
                    q = new Link<>(i.data) ;
                    p.next = q;
                    p = q;
                }
                i = i.next;
            }
            p.next = null;
            return c;
        }

}
