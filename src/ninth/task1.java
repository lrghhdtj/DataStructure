package ninth;

import P.AVT.ATClass;

public class task1 {
    public static void main(String[] args) {
        // 将整数序列（4，5，7，2，1，3，6）中的整数依次插入到一棵空的平衡二叉树中，试构造相应的平衡二叉树。
        ATClass atClass = new ATClass();
        atClass.inser(4);
        atClass.inser(5);
        atClass.inser(7);
        atClass.inser(2);
        atClass.inser(1);
        atClass.inser(3);
        atClass.inser(6);
        atClass.print_in();
        atClass.print_pre();

    }
}
