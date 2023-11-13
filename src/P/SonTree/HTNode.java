package P.SonTree;

import P.SonTree.tLinkList;

public class HTNode<E> {
    public E data;
    public tLinkList childlist;
    public HTNode(){
        childlist = null;
    }
    public HTNode(E e){
        data = e;
        childlist = null;
    }


}
