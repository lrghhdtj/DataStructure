package experiment4;

import P.BTNode;
import P.BTreeClass;

import java.util.Stack;

public class exchtree {
    public static void main(String[] args) {
        //1.根据A(B(D(，G))，C(E，F))建立二叉树；
        BTreeClass bTreeClass = new BTreeClass();
        bTreeClass.createtree("A(B(D(,G)),C(E,F))");
        System.out.println(bTreeClass.toString());
        //2.分别按照前序、中序历遍打印这颗树的数据节点；
        System.out.print("前序：");
        bTreeClass.print_pre();
        System.out.print("中序：");
        bTreeClass.print_in();
        //3.将这颗二叉树中所有节点的左右孩子交换；
        transfrom(bTreeClass);
        //4.分别按照前序、中序历遍打印交换后的树的数据节点；
        System.out.print("前序：");
        bTreeClass.print_pre();
        System.out.print("中序：");
        bTreeClass.print_in();
        //5.销毁二叉树。
        bTreeClass.release();
    }
public static void transfrom(BTreeClass bTreeClass){
      Stack<BTNode> stack = new Stack<>();
      BTNode<Character> p = bTreeClass.b,tmp;
      Character t ;
      while (!stack.empty()||p != null){
         while (p!= null){
             stack.push(p);
             if (p.rchild != null && p.lchild != null) {
                 t = (Character) p.lchild.data;
                 p.lchild.data = p.rchild.data;
                 p.rchild.data = t;
             }else {
                 if (p.lchild == null){
                      tmp = p.rchild;
                     p.rchild = null;
                     p.lchild = tmp;
                 } else {
                     tmp = p.lchild;
                     p.lchild = null;
                     p.rchild = tmp;
                 }
             }
             p = p.lchild;
         }
         if(!stack.empty()){
             p = stack.pop();
             p = p.rchild;
         }
      }
}
}
