package five;

import java.util.Stack;

public class BTreeClass {
    BTNode <Character> b ;
    String bstr;
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
        bstr = "";
        toStringx(b);
        return bstr;
    }

    private void toStringx(BTNode<Character> btNode) {
        if(btNode != null){
            bstr += btNode.data;
            if (btNode.lchild != null ||btNode.rchild != null){
                bstr += "(";
                toStringx(btNode.lchild);
                if (btNode.rchild!= null){
                    bstr += ",";
                    toStringx(btNode.rchild);
                    bstr += ")";
                }
            }
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
        mindistancex(b);
    }

    private void mindistancex(BTNode<Character> btNode) {
        Stack<BTNode> stack = new Stack<>();
        int n =1,min =1;
        BTNode <Character> p = btNode ;
        while (!stack.empty() || p != null){
            while (p != null){
            stack.push(p);
            p = p.lchild;
            n++;
                if (p.rchild == null && p.lchild == null){
                    if (n < min){
                        min = n;
                    }
                    n = 1;
                }
            }
            if (!stack.empty()){
                p = stack.pop();
                p = p.rchild;
            }

        }
        System.out.println(min);
    }



}
