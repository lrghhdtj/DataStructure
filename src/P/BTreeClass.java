package P;

import java.util.*;

public class BTreeClass {
    public BTNode<Character> b ;
    String str;
    public BTreeClass(){
        b = null;
    }
    public void createtree(String s){
        Stack<BTNode> t = new Stack<BTNode>();
        BTNode<Character> p = null;
        boolean tag = true;
        char a;
        int i = 0;
        while (i < s.length()){
            a = s.charAt(i);
            switch (a){
                case '(' :{
                    t.push(p);
                    tag = true;
                    break;
                }
                case ')':{
                    t.pop();
                    break;
                }
                case ',' :{
                    tag = false;
                    break;
                }
                default:{
                    p = new BTNode<>(a);
                    if( b == null){
                        b = p;
                    }else {
                        if(tag){
                            if (!t.empty()){
                               t.peek().lchild = p;
                            }
                        }else {
                            if (!t.empty()){
                                t.peek().rchild = p;
                            }
                        }
                    }

                }
                break;
            }
            i++;
        }
    }
    public String toString(){
        str = "";
        toStringx(b);
        return str;
    }

    private void toStringx(BTNode<Character> btNode) {
        if(btNode != null){
            str += btNode.data;
            if (btNode.lchild != null ||btNode.rchild != null){
                str += "(";
                toStringx(btNode.lchild);
                if (btNode.rchild!= null){
                    str += ",";
                    toStringx(btNode.rchild);
                    str += ")";
                }
            }
        }
    }
    public int height(){
        return heightx(b);
    }

    private int heightx(BTNode<Character> btNode) {
        int lchildh,rchildh;
        if (btNode == null){
            return 0;
        }else {
            lchildh = heightx(btNode.lchild);
            rchildh = heightx(btNode.rchild);
            return Math.max(lchildh,rchildh) +1;
        }
    }
    public void print_leavesnode(){
       print_leavesnodex(b);

    }
    private void print_leavesnodex(BTNode<Character> btNode){
        if (btNode != null){
            if (btNode.lchild == null && btNode.rchild == null) {
                System.out.print(btNode.data);
            } else {
                print_leavesnodex(btNode.rchild);
                print_leavesnodex(btNode.lchild);
            }

        }
    }
    public void mindistance(){
        System.out.println(mindistancex(b)-1);
    }

    private int mindistancex(BTNode<Character> btNode) {
        int lchildh,rchildh;
        if (btNode == null){
            return 0;
        }else {
            lchildh = mindistancex(btNode.lchild);
            rchildh = mindistancex(btNode.rchild);
            return Math.min(lchildh,rchildh) +1;
        }
    }

    public void print_pre(){
        print_prex(b);
        System.out.println();
    }

    private void print_prex(BTNode<Character> b) {
        if (b != null){
            System.out.print(b.data+" ");
            print_prex(b.lchild);
            print_prex(b.rchild);
        }
    }

    public void print_in(){
        print_inx(b);
        System.out.println();
    }

    private void print_inx(BTNode<Character> b) {
        if (b !=  null){
            print_inx(b.lchild);
            System.out.print(b.data+" ");
            print_inx(b.rchild);
        }
    }
    public void print_level(){
        BTNode p;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(b);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                p = queue.poll();
                System.out.print(p.data + " ");
                if (p.lchild != null) {
                    queue.offer(p.lchild);
                }
                if (p.rchild != null) {
                    queue.offer(p.rchild);
                }
                size--;
            }
        }
    }

    public void release(){
        b = null;
}
    public int level(BTNode btNode,char x){
        return levelx(b,x,1);
    }

    private int levelx(BTNode<Character> b,char x,int h) {
        if (b == null){
            return 0;
        }else if (b.data == x){
            return 1;
        }else {
            int  l = levelx(b.lchild ,x ,h+1);
            if (l !=0){
                return l;
            }else {
                return levelx(b.rchild , x, h+1);
            }
        }
    }
    public  void creatrby_pre_in(int[] preorder, int[] inorder) {
        BTNode<Integer> bt =createby_pre_inx(preorder,0,inorder,0,preorder.length);

    }
    private  BTNode<Integer> createby_pre_inx(int[] preorder, int i, int[] inorder, int j, int length) {
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
        b.lchild = createby_pre_inx(preorder,i+1,inorder,j,k);
        b.rchild = createby_pre_inx(preorder,i+k+1,inorder,p+1,length-k-1);
        return b;
    }
}
