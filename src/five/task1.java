package five;

public class task1 {
    public static void main(String[] args) {
        BTreeClass bTreeClass = new BTreeClass();
        bTreeClass.createtree("A(B(E,F),C(G(J)),D(H,I(K,L)))");
        //bTreeClass.createtree("A(B(D(,G)),C)");
        bTreeClass.print_leavesnode();
        System.out.println();
        bTreeClass.mindistance();
    }
}
