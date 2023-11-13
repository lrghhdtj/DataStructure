package P.SonTree;

public class tLinkList <E>{
        CTNode<E> head;
        public tLinkList(){
            head = new CTNode<>();
            head.next = null;
        }
        public void Creat(E[] e){
            CTNode<E> a,b;
            b = head;
            for (int i = 0; i <e.length;i++){
                a = new CTNode<>(e[i]);
                b.next = a;
                b =a;
            }
            b.next =null;
        }
        public void add(E e){
            CTNode<E> n = new CTNode<>(e);
            CTNode<E> m = head;
            while (m.next != null){
                m = m.next;
            }
            m.next =n;
        }
        public int size(){
            CTNode<E> m = head;
            int t= 0;
            while (m.next != null){
                m = m.next;
                t++;
            }
            return t;
        }
        private CTNode<E> getindex(int i){
            CTNode<E> n = head;
            int j =-1;
            while (j <i){
                j++;
                n =n.next;
            }
            return n;
        }
        public E get(int i){
            if (i <0 || i > size() -1){
                throw new IllegalArgumentException("无效索引！");
            }else {
                CTNode<E> n = getindex(i);
                return (E) n.child;
            }
        }
        public void set(int i ,E e){
            if (i <0 || i > size() -1){
                throw new IllegalArgumentException("无效索引！");
            }else {
                CTNode<E> link = getindex(i);
                link.child =  e;
            }
        }

    }
