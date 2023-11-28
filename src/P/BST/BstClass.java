package P.BST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BstClass {
    private String str ;
    public BstNode r;
    private  BstNode f;
    public BstClass(){
        r = null;
    }
    int mun;
    public void createBst(double [] a){
        r = new BstNode();
        r.key = a[0];
        for (int i = 0; i < a.length; i++) {
            InsertBstx(r,a[i]);
        }
        mun = a.length;
    }

    public void InsertBst( double t) {
        InsertBstx(r,t);
    }

    private BstNode InsertBstx(BstNode r, double t) {
        if (r == null){
            r = new BstNode();
            r.key = t;
        }else if (t < r.key){
            r.lchild = InsertBstx(r.lchild,t);
        }else if (t > r.key){
            r.rchild = InsertBstx(r.rchild,t);
        }
        return r;
    }
    public BstNode search(double k){
        return searchx(r,k);
    }

    private BstNode searchx(BstNode p, double k) {
        if (p == null){
            return null;
        }else {
            System.out.print(p.key+" ");
            if (p.key == k) {
                return r;
            }
            if (k < p.key) {
                return searchx(p.lchild, k);
            } else {
                return searchx(p.rchild, k);
            }
        }
    }
    public void find(double k){
        findx(r,k);
    }

    private void findx(BstNode p, double k) {
        BstNode bstNode;
        Stack<BstNode> stack = new Stack<>();
        stack.push(p);
        while (!stack.empty()){
            bstNode = stack.pop();
            System.out.print(bstNode.key+" ");
            if (bstNode.key == k){
                break;
            }
            if (bstNode.key> k && bstNode.lchild != null){
                stack.push(bstNode.lchild);
            }
            if (bstNode.key < k && bstNode.rchild != null){
                stack.push(bstNode.rchild);
            }
        }
    }

    public boolean deletenode(double k){
        f =null;
        return deletenodex(r,k,-1);
    }

    private boolean deletenodex(BstNode p, double k, double flag) {
        if (p == null){
            return false;
        }
        if (p.key == k){
            return delete(p,f,flag);
        }
        if (p.key > k){
            f = p;
            return deletenodex(p.lchild,k,0);
        }else {
            f = p;
            return deletenodex(p.rchild,k,1);
        }
    }
    private boolean delete(BstNode p,BstNode f,double flag){
        if (p.rchild == null){
            if (flag == -1){
                r = p.lchild;
            }else if (flag == 0){
                f.lchild = p.lchild;
            }else {
                f.rchild = p.lchild;
            }
        }else if (p.lchild == null){
            if (flag == -1){
                r =p.rchild;
            }else if (flag == 0){
                f.lchild = p.rchild;
            }else {
                f.rchild = p.rchild;
            }
        }else {
            BstNode t = p;
            BstNode q = p.lchild;
            if (q.rchild == null){
                p.key = q.key;
                p.lchild = q.lchild;
            }else {
                while (q.rchild != null){
                    t = q;
                    q = q.rchild;
                }
                p.key = q.key;
                t.rchild = q.lchild;
            }
        }
        return true;
    }
    public void isBst(){
        ArrayList<Double> list = new ArrayList<>();
        boolean flag = true;
        isBstx(r,list);
        for (int i = 0; i < mun -1 ; i++) {
            if (list.get(i) > list.get(i+1)){
                flag = false;
            }
        }
        if (flag){
            System.out.println("是二叉排序树");
        }else {
            System.out.println("不是二叉排序树");
        }
    }

    private ArrayList<Double> isBstx(BstNode r, ArrayList<Double> list ){
        if (r != null) {
                isBstx(r.lchild,list);
                    list.add(r.key);
                isBstx(r.rchild,list);

        }
        return list;
    }
    public void print_in(){
        print_inx(r);
        System.out.println();
    }

    private void print_inx(BstNode r) {
        if (r != null){
            print_inx(r.lchild);
            System.out.print(r.key + " ");
            print_inx(r.rchild);
        }
    }

    public String toString(){
        str = "";
        toStringx(r);
        return str;
    }
    private void toStringx(BstNode bstNode) {
        if(bstNode != null){
            str += bstNode.key;
            if (bstNode.lchild != null ||bstNode.rchild != null){
                str += "(";
                toStringx(bstNode.lchild);
                if (bstNode.rchild!= null){
                    str += ",";
                    toStringx(bstNode.rchild);
                    str += ")";
                }
            }
        }
    }
}
