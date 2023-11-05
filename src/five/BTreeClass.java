package five;

import java.util.Stack;

public class BTreeClass {
    public BTNode<Character> b ;
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
    public void height(){
        System.out.println(mindistancex(b));
    }

    private int heightx(BTNode<Character> btNode) {
        int lchildh,rchildh;
        if (btNode == null){
            return 0;
        }else {
            lchildh = mindistancex(btNode.lchild);
            rchildh = mindistancex(btNode.rchild);
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
public void release(){
        b = null;
}

}
