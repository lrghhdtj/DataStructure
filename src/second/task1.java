package second;

public class task1 {
    //有一个整数单链表L，设计一个尽可能高效算法将所有负整数的元素移到其他元素的前面。例如，L=（1，2，-1，-2，3，-3，4），移动后L=（-1，-2，-3，1，2，3，4）。
    public static void main(String[] args) {
        Integer [] t = {1,2,-1,-2,3,-3,4};
        Linklist<Integer> L = new Linklist<>();
        L.Creat(t);
        for (int i = 0; i <L.size() ; i++) {
            System.out.print(L.get(i)+" ");
        }
        System.out.println();
        L = swapnegativenum(L);
        for (int i = 0; i <L.size() ; i++) {
            System.out.print(L.get(i)+" ");
        }

    }
    public static Linklist<Integer> swapnegativenum(Linklist<Integer> l){
        Linklist<Integer> n = new Linklist<>();//   <0
        Linklist<Integer> m = new Linklist<>();//   >0
        for (int i = 0; i <l.size(); i++) {
            if (l.get(i) < 0){
                n.add(l.get(i));
            }
            if (l.get(i) > 0){
                m.add(l.get(i));
            }
        }
        if (m.size() >0 && n.size() > 0){
            for (int i = 0; i <m.size() ; i++) {
                n.add(m.get(i));
            }
        }
        return n;

    }
}
