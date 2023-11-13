package sixth;

import P.BTNode;
import P.BTreeClass;

import java.util.*;

public class task1 {
    public static void main(String[] args) {
        BTreeClass bTreeClass = new BTreeClass();
        //bTreeClass.createtree("A(B(E,F),D(H,I(K,L)))");
        //bTreeClass.createtree("A(B(D(,G)),C)");
        bTreeClass.createtree("A(B(D(,F(H,)),E(G,)),C)");
        System.out.println(bTreeClass.toString());
        layer(bTreeClass.b);
    }
    public static void layer(BTNode<Character> btNode){
        BTNode<Character> p = btNode,head = btNode;

        Stack<BTNode> stack = new Stack<>();
        int t = 1,j=0;
        while (!stack.empty() ||p != null){
            while (p != null){
                System.out.println(p.data +"，第"+ t +"层");
                stack.push(p);
                p= p.lchild;
                t++;
            }
            if (!stack.empty()){
                p = stack.pop();
                j++;
                if (p == head){
                    j = 0;
                    head = p.rchild;
                }
                p = p.rchild;
                if (p == null){
                    t -= j;
                    j = 0;
                }
            }
        }
    }


}
