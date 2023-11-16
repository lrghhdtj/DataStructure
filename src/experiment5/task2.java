package experiment5;
import P.BTNode;
import P.BTreeClass;

public class task2 {
    public static void main(String[] args) {
        BTreeClass bTreeClass = new BTreeClass();
        /*bTreeClass.createtree("A(B(D(,G)),C(E,F))");
        bTreeClass.print_level();*/
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        createtree(preorder, inorder);

    }
    public static void createtree(int[] preorder, int[] inorder) {
         BTNode<Integer> bt =createtreex(preorder,0,inorder,0,preorder.length);

    }
    private static BTNode<Integer> createtreex(int[] preorder, int i, int[] inorder, int j, int length) {
        BTNode<Integer> b;
        int t,p,k;
        if (length <=  0){
            return null;
        }
        t = preorder[i];
        b = new BTNode<Integer>(t);
        p = j;
        while (p < j+length){
            if (inorder[p] == t){
                break;
            }
            p++;
        }
        k = p - j;
        b.lchild = createtreex(preorder,i+1,inorder,j,k);
        b.rchild = createtreex(preorder,i+k+1,inorder,p+1,length-k-1);
        return b;
    }




}
