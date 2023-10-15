package experiment1;

    public class Link <E>{
        E data;
        Link<E> next;

        public Link () {
            next = null;
        }
        public Link(E e){
            data= e;
            next = null;
        }
}
