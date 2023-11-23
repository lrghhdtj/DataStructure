package P.AVT;

public class ATClass {
    ANode r;
    int mun;
    public  ATClass (){
        r = null;
    }

    public void inser(int k){
        r = inserx(r,k);
    }

    private ANode inserx(ANode aNode, int k) {
        if (aNode == null){
            aNode = new ANode(k);
        }else if (aNode.data > k){
            aNode.lchild = inserx(aNode.lchild,k);
        }else if (aNode.data < k){
            aNode.rchild = inserx(aNode.rchild,k);
        }
        aNode.height = Math.max(getheight(aNode.lchild), getheight(aNode.rchild)) +1;
        mun++;
        return balance(aNode);
    }

    private ANode balance(ANode aNode) {
        if (aNode == null) {
            return null;
        }//左子树高
        else if (getheight(aNode.lchild) - getheight(aNode.rchild) > 1) {
            if (getheight(aNode.lchild.lchild) > getheight(aNode.lchild.rchild)){
                //LL
                aNode = change_LL(aNode);
            }else {
                //LR
                aNode = change_LR(aNode);
            }
        }// 右子树高
        else if (getheight(aNode.rchild) - getheight(aNode.lchild) > 1) {
            if (getheight(aNode.rchild.rchild) > getheight(aNode.rchild.lchild)){
                //RR
                aNode = change_RR(aNode);
            }else {
                //RL
                aNode =change_RL(aNode);
            }

        }
        return aNode;
    }


    private ANode change_LL(ANode aNode){
            ANode left = new ANode();
            left = aNode.lchild;
            aNode.lchild = left.rchild;
            left.rchild = aNode;
            aNode.height = Math.max(getheight(aNode.rchild), getheight(aNode.lchild)) + 1;
            left.height = Math.max(aNode.height, getheight(left.lchild)) + 1;
            return left;
    }
    private ANode change_RR(ANode aNode){
            ANode right = new ANode();
            right = aNode.rchild;
            aNode.rchild = right.lchild;
            right.lchild = aNode;
            aNode.height = Math.max(getheight(aNode.rchild), getheight(aNode.lchild)) + 1;
            right.height = Math.max(aNode.height, getheight(right.rchild)) + 1;
            return right;
    }
    private ANode change_LR(ANode aNode){
        aNode.lchild = change_LL(aNode.lchild);
        return change_RR(aNode);

    }
    private ANode change_RL(ANode aNode){
        aNode.rchild = change_RR(aNode.rchild);
        return change_LL(aNode);
    }
    private int getheight(ANode aNode){
        if (aNode != null){
            return aNode.height;
        }
        return -1;
    }
    public void print_in(){
        print_inx(r);
    }

    private void print_inx(ANode r) {
        if (r != null) {
            print_inx(r.lchild);
            System.out.print(r.data+" ");
            print_inx(r.rchild);
        }
    }
    public void print_pre(){
        print_prex(r);
    }

    private void print_prex(ANode r) {
        if (r != null){
            System.out.println(r.data+" ");
            print_prex(r.lchild);
            print_prex(r.rchild);
        }
    }

}
