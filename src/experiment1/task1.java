package experiment1;

public class task1 {
    public static void main(String[] args) {
        Linklist<Character> linklist = new Linklist<>();
        linklist.add('a');
        linklist.add('b');
        linklist.add('c');
        linklist.add('d');
        linklist.add('e');
        linklist.print();
        System.out.println(linklist.size());
        System.out.println(linklist.empty());
        //输出单链表h的第3个元素
        System.out.println(linklist.get(2));
        //输出元素a的位置。
        System.out.println(linklist.indexof('a'));
        //在第4个元素的位置上插入f元素。
        linklist.insert('f',3);
        linklist.print();
        //删除单链表h的第3个元素。
        linklist.delete(2);
        linklist.print();
        linklist.release();
    }
}
