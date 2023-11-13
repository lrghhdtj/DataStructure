package P;

public class StackClass <E>{

    final int icapacity = 10;
    private  int capacity;
    private E [] data;
    private int top;
    public StackClass(){
        data = (E[]) new Object[icapacity];
        capacity = icapacity;
        top =-1;
    }
    private void updatecapacity(int newcapacity){
        E[] newdata = (E[]) new Object[newcapacity];
        for (int i = 0; i <= top; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
        capacity = newcapacity;
    }
    public boolean empty(){
        return top == -1;
    }
    public void push(E e){
        if (top == capacity -1){
            updatecapacity(2 *(top+1));
        }
        top++;
        data[top] =e;
    }
    public E pop(){
        if (empty()){
            throw new IllegalArgumentException("柞空！");
        }
        E e = data[top];
        top--;
        return e;
    }
    public E peek(){
        if (empty()){
            throw new IllegalArgumentException("柞空！");
        }
        return data[top];
    }
}
