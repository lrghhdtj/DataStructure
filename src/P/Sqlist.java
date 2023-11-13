package P;
public class Sqlist <E>{
    final int initcapacity = 10;
    public E [] data;
    public int size;
    private int capacity;
    public Sqlist(){
        data = (E[])new Object[initcapacity];
        capacity = initcapacity;
        size=0;
    }
    private void addcapacity(int newcapacity){
        E [] newd =  (E[]) new Object[newcapacity];
        for (int i = 0; i < size; i++) {
            newd[i] = data[i];
            capacity = newcapacity;
            data = newd;
        }
    }
    public void add(E e){
        if (size == capacity){
            addcapacity(2 *size);
        }else {
            data[size] =e;
            size++;
        }
    }
    public void set(int i,E e) throws Exception {
        if (i <0 || i >size-1){
            throw new Exception("超过索引有效范围！");
        }else {
            data[i] = e;
        }
    }
    public E get(int i) throws Exception {
        if (i <0 || i >size-1){
            throw new Exception("超过索引有效范围！");
        }else {
            return (E)data[i];
        }
    }

   public void deletnegation(Sqlist<Integer> list) throws Exception {
        int k=0;
       for (int i = 0; i <list.size ; i++) {
           if(list.get(i) >0){
               list.set(k,list.get(i));
               k++;
           }
       }
       list.size =k;
   }
   //删除表中值大于等于x且小于等于y的所有元素（x≤y）
   public void deletxy(Sqlist<Integer> list ,int x,int y) throws Exception {
       int k=0;
       if (y<x){
           throw new Exception("参数异常！");
       }else {
       for (int i = 0; i <list.size ; i++) {
           if(list.get(i) < x || list.get(i) > y) {
               list.set(k, list.get(i));
               k++;
           }
       }
       }
       list.size =k;
   }
}

