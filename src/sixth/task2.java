package sixth;
import P.BTNode;
import P.BTreeClass;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class task2 {
    public static void main(String[] args) {
        BTreeClass bTreeClass1 = new BTreeClass();
        BTreeClass bTreeClass2 = new BTreeClass();
        bTreeClass1.createtree("A(B(E,F),D(H,I(K,L)))");
        bTreeClass2.createtree("A(B(C,D),B(D,C))");
        symmetry(bTreeClass1);
        symmetry(bTreeClass2);
    }
    public static void symmetry(BTreeClass bTreeClass ){
        boolean result = symmetryx(bTreeClass.b);
        System.out.print(bTreeClass.toString());
        if (result){
            System.out.println("是镜像对称");
        }else {
            System.out.println("不是镜像对称");
        }
    }

    private static Boolean symmetryx(BTNode<Character> btNode) {
        String s = "";
        Stack<BTNode> st = new Stack<>();
        BTNode<Character> p =btNode ;
        while (!st.empty() || p != null){
            while (p != null){
                st.push(p);
                p =p .lchild;
            }
            if (!st.empty()){
                p = st.pop();
                s += p.data;
                p =p.rchild;
            }
        }
 //---------------------------------------------------------
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        int len = s.length(), t = 0;
        int halflen = (len -1) /2;
        if (len % 2 == 0){
            return false;
        }else {
            for (int i = 0; i < (len -1) / 2; i++) {
                stack.push(String.valueOf(s.charAt(i)));
            }
            for (int i = halflen+1; i < len; i++) {
                queue.offer(String.valueOf(s.charAt(i)));
            }
            while (t < halflen){
                if (!queue.poll().equals(stack.pop())){
                    return false;
                }else {
                    t++;
                }
            }
        }
        return true;
    }
}
