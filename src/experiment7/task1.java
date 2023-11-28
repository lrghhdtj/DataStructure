package experiment7;

import P.BST.BstClass;

public class task1 {
    public static void main(String[] args) {
        BstClass bstClass = new BstClass();
        // 1）由关键字序列（4，9，0.1，8，6，3，5，2，7）创建一棵二叉排序树bt并以括号表示法输出。
        double []a = {4,9,0.1,8,6,3,5,2,7};
        bstClass.createBst(a);
        System.out.println(bstClass.toString());
         //（2）判断bt是否为一棵二叉排序树。
        bstClass.isBst();
        //（3）采用递归和非递归两种方法查找关键字为6的结点，并输出其查找路径。
        System.out.print("递归:");
        bstClass.search(6);
        System.out.println();
        System.out.print("非递归:");
        bstClass.find(6);
         //（4）分别删除bt中关键字为4和5的结点，并输出删除后的二叉排序树。
        System.out.println();
        bstClass.deletenode(4);
        bstClass.deletenode(5);
        System.out.println(bstClass.toString());
    }
}
