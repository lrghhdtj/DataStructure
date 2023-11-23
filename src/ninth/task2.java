package ninth;

import P.BST.BstClass;

public class task2 {
    public static void main(String[] args) {
        //设计一个算法，判断给定的一棵二叉树是否是二叉排序树，假设二叉排序树中所有关键字均为正整数
        //int [] a ={5,2,1,6,7,4,3};
        int [] a ={4,5,7,2,1,3,6};
        BstClass bstClass = new BstClass();
        bstClass.createBst(a);
        bstClass.isBst();

    }
}
