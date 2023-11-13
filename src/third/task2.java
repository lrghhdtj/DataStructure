package third;

import P.QueueClass;

public class task2 {
    /*设计一个循环队列，用data[0..MaxSize-1]存放队列元素，用front和rear分别作为队头和队尾指针，
    另外用一个标志tag标识队列可能空（false）或可能满（true），
    这样加上front==rear可以作为队空或队满的条件。要求设计队列的相关基本运算算法。
     */
    public static void main(String[] args) {
        QueueClass<Integer> queueClass = new QueueClass<>();
        queueClass.push(11);
        queueClass.push(22);
        queueClass.push(3);
        queueClass.push(46);
        System.out.println("最小值："+queueClass.min(queueClass));
        if (queueClass.contain(3)) {
            System.out.println("队列包含元素3");
        }
        for (int i = 0; i < queueClass.size() ; i++) {
            System.out.println(queueClass.dataindexof(queueClass,i));
        }
    }
}
