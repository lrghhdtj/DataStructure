package first;
public class task2 {
    public static void main(String[] args) throws Exception {
        Sqlist<Integer> L= new Sqlist<>();
        //4，2，1，5，3，6，4，x=2，y=4
        L.add(4);
        L.add(2);
        L.add(1);
        L.add(5);
        L.add(3);
        L.add(6);
        L.add(4);
        for (int i = 0;i<L.size ;i++){
            System.out.print(L.get(i)+" ");
        }
        System.out.println();
        L.deletxy(L,2,4);
        for (int i = 0;i<L.size ;i++){
            System.out.print(L.get(i)+" ");
        }





    }
}
