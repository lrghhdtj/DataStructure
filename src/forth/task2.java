package forth;

import P.Linklist;

public class task2 {
    //设有一个不带表头结点的整数单链表p，设计一个递归算法getno(p，x)查找第一个值为x的结点的序号（假设首结点的序号为0），没有找到时返回-1。
    public static void main(String[] args) {
        Linklist<Integer> linklist = new Linklist<>();
        linklist.add(1);
        linklist.add(2);
        linklist.add(3);
        linklist.add(4);
        System.out.println(linklist.getno(linklist.head,3));

    }
}
