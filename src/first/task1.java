package first;

import P.Sqlist;

public class task1 {
    public static void main(String[] args) throws Exception {
       Sqlist<Integer> L= new Sqlist<>();
       //1，2，-1，-2，3，-3
       L.add(1);
       L.add(2);
       L.add(-1);
       L.add(-2);
       L.add(3);
       L.add(-3);
        for (int i = 0;i<L.size ;i++){
            System.out.print(L.get(i)+" ");
        }
        L.deletnegation(L);
        System.out.println();
        for (int i = 0;i<L.size ;i++){
            System.out.print(L.get(i)+" ");
        }
    }
}
