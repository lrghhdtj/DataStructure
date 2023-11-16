package five;

import P.BTreeClass;

public class task1 {
    public static void main(String[] args) {
        BTreeClass bTreeClass = new BTreeClass();
        bTreeClass.createtree("A(B(E,F),D(H,I(K,L)))");
        //bTreeClass.createtree("A(B(D(,G)),C)");
        System.out.print("从右到左的次序二叉树中的所有叶子结点:");
        bTreeClass.print_leavesnode();
        System.out.println();
        System.out.print("二叉树的最小枝长:");
        bTreeClass.mindistance();
    }
}
