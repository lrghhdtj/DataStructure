package P;

public class QueueClass <E>{
    final int maxsize = 6;
    private E[] data;
    private int front,rear;
    String tag = "false";
    public QueueClass(){
        data = (E[]) new Object[maxsize];
        rear = 0;
        front = 0;
    }
    public boolean empty(){
        return rear == front;
    }
    public void push(E e){
        if ((rear +1 ) % maxsize ==front){
            tag = "true";
            throw new IllegalArgumentException("队列已满！");
        }else {
            rear = (rear +1) % maxsize;
            data[rear] = e;
            if ((rear +1 ) % maxsize ==front){
                tag = "true";
            } else {
            tag = null;
            }
        }
    }
    public E pop(){
        if (empty()){
            throw new IllegalArgumentException("队列为空！");
        }else {
            front = (front +1 ) % maxsize;
            if (rear == front){
                tag = "false";
            }
            return data[front];
        }
    }
    public E peek(){
        if (empty()){
            throw new IllegalArgumentException("队列为空！");
        }else {
            return data[(front +1 ) % maxsize];
        }
    }
    public int size (){
        return ((rear - front + maxsize) % maxsize);
    }
    public void print(){
        if (!empty()) {
            for (int i = front+1; i <= rear; i++) {
                System.out.println(data[i]);
            }
        }else {
            System.out.println("null");
        }
    }

    public boolean contain(E e){
        int i = 0;
       while (i < size()){
           if (data[i] == e){
               i++;
               return true;
           }else {
               i++;
           }
       }
        return false;
    }
    public E dataindexof(QueueClass<E> queueClass ,int index){
        E e = null;
        if (index < 0 || index >size() -1){
            throw new IllegalArgumentException("参数错误！");
        }else {
            for (int i = 0; i < size(); i++) {
                if ( i != index){
                    queueClass.push(queueClass.pop());
                }else {
                    e = queueClass.peek();
                    queueClass.push(queueClass.pop());
                }
            }
        }
        return e;
    }


    public Integer min(QueueClass<Integer> queueClass){
        int i = 0;
        Integer min = queueClass.pop();
        while (i < queueClass.size()-1){
            if (queueClass.peek() < min){
                queueClass.push(min);
                min = queueClass.pop();
                queueClass.push(min);
                i++;
            }else {
                queueClass.push(queueClass.pop());
                i++;
            }
        }
        return min;
    }

}
