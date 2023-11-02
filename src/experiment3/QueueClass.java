package experiment3;
public class QueueClass<E> {
    final int maxsize = 100;
    private E[] data;
    private int front ,rear;
    public  QueueClass(){
        data = (E[]) new Object[maxsize];
        front = -1;
        rear = -1;
    }
    public boolean empty(){
        return front == rear;
    }
    public void push(E e){
        if (rear ==maxsize-1){
            throw new IllegalArgumentException("队满！");
        }
        else {
            rear++;
            data[rear] =e;
        }
    }
    public E pop(){
        if(empty()){
            throw new IllegalArgumentException("队空！");
        }
        else {
            front++;
            return (E)data[front];
        }
    }
    public E peek() {
        if (empty()) {
            throw new IllegalArgumentException("队空！");
        } else {
            return (E) data[front + 1];
        }
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
}
