package experiment2;

public class dlink_main {
    public static void main(String[] args) {
        //初始化双链表h。
        dlinklist linklist = new dlinklist<Character>();
        //依次采用尾插法插入a、b、c、d、e元素。
        linklist.add('a');
        linklist.add('b');
        linklist.add('c');
        linklist.add('d');
        linklist.add('e');
        //输出双链表h。
        linklist.print();
        //输出双链表h的长度。
        System.out.println(linklist.size());
        //判断双链表h是否为空。
        System.out.println("链表是否为空："+linklist.empty());
        //输出双链表h的第3个元素。
        System.out.println("链表的第3个元素:"+linklist.get(2));
        //输出元素a的位置。
        System.out.println("元素a的索引位置："+linklist.indexof('a'));
        //在第4个元素的位置上插入f元素。
        System.out.print("在第4个元素的位置上插入f元素:");
        linklist.insert('f',3);
        //输出双链表h。
        linklist.print();
        //删除双链表h的第3个元素。
        System.out.print("删除双链表h的第3个元素:");
        linklist.delete(2);
        //输出双链表h。
        linklist.print();
        //释放双链表h。
        linklist.release();


    }
}
