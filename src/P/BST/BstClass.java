package P.BST;

import java.util.ArrayList;

public class BstClass {
    public BstNode r;
    private  BstNode f;
    public BstClass(){
        r = null;
    }
    int mun;
    public void createBst(int [] a){
        r = new BstNode();
        r.key = a[0];
        for (int i = 0; i < a.length; i++) {
            InsertBstx(r,a[i]);
        }
        mun = a.length;
    }

    public void InsertBst( int t) {
        InsertBstx(r,t);
    }

    private BstNode InsertBstx(BstNode r, int t) {
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
    public BstNode search(int k){
        return searchx(r,k);
    }

    private BstNode searchx(BstNode r, int k) {
        if (r == null){
            return null;
        }
        if (r.key == k){
            return r;
        }
        if (k < r.key){
           return searchx(r.lchild,k);
        }else {
            return searchx(r.rchild,k);
        }
    }
    public boolean deletenode(int k){
        f =null;
        return deletenodex(r,k,-1);
    }

    private boolean deletenodex(BstNode r, int k, int flag) {
        if (r == null){
            return false;
        }
        if (r.key == k){
            return delete(r,f,flag);
        }
        if (r.key > k){
            return deletenodex(r.lchild,k,0);
        }else {
            return deletenodex(r.rchild,k,1);
        }
    }
    private boolean delete(BstNode p,BstNode f,int flag){
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
        ArrayList<Integer> list = new ArrayList<>();
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

    private ArrayList<Integer> isBstx(BstNode r, ArrayList<Integer> list ){
        if (r != null) {
                isBstx(r.lchild,list);
                    list.add(r.key);
                isBstx(r.rchild,list);

        }
        return list;
    }
}
