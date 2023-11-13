package P.SonTree;

import experiment4.unite;

import java.util.*;

public class CTreeClass {
    HTNode[] headlist;
    public void create(unite[] r){
        unite [] R =r;
        ArrayList<HTNode> list = addtolist(R);
        headlist = new HTNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            headlist[i] = list.get(i);
        }
        createchild(R);

    }
private ArrayList addtolist(unite [] t){
    ArrayList<HTNode> list = new ArrayList<>();
    boolean notexit = true;
    HTNode<String> htNode;
    for (int i = 0; i < t.length; i++) {
        htNode = new HTNode<>(t[i].getName());
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).data.equals(htNode.data)) {
                notexit = false;
                break;
            }
        }
        if (notexit) {
            list.add(htNode);
        }
        notexit = true;
    }
    for (int i = 0; i < t.length; i++) {
        htNode = new HTNode<>(t[i].getNextdep());
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).data.equals(htNode.data)) {
                notexit = false;
                break;
            }
        }
        if (notexit) {
            list.add(htNode);
        }
        notexit = true;
    }
    return list;
}

private void createchild(unite [] t) {
        CTNode<Integer> c;
    for (int i = 0; i < headlist.length; i++) {
        tLinkList<CTNode> clist = new tLinkList<>();
        for (int j = 0; j < t.length; j++) {
            if (headlist[i].data.equals(t[j].getName()) ){
                for (int k = 0; k < headlist.length; k++) {
                    if (t[j].getNextdep().equals(headlist[k].data)){
                        c = new CTNode<Integer>(k);
                        clist.add(c);
                    }
                }
            }
        }
        headlist[i].childlist = clist;
    }
}

    public void tostring(){
        tLinkList<CTNode> clist;
        String s = "";
        int n;
        for (int i = 0; i <headlist.length ; i++) {
            clist = headlist[i].childlist;
            if (clist.size() != 0){
                System.out.print(headlist[i].data);
                s +="(";
                for (int j = 0; j <clist.size() ; j++) {
                    n = (int)clist.get(j).child;
                    s += headlist[n].data;
                    if (j <clist.size()-1){
                        s +=",";
                    }
                }
                s += ")";
                System.out.println(s);
                s = "";
            }

        }
    }






    public void sumson(String s){
        int result = sumsons(s);
        if (result != 0){
            System.out.println(result);
        }
    }

    private int sumsons(String s) {
        int i = 0;
        tLinkList<CTNode> t;
        for (int j = 0; j < headlist.length; j++) {
            t = headlist[j].childlist;
            if (headlist[j].data.equals(s)){
                i = t.size();
            }
        }
        return i;
    }

    public void sumgson(String s){
        int result = sumgsons(s);
        if (result != 0){
            System.out.println(result);
        }
    }

    private int sumgsons(String s) {
        int i = 0,n;
        tLinkList<CTNode> list;
        HTNode h;
        Queue<HTNode> queue = new LinkedList<>();
        for (int j = 0; j < headlist.length; j++) {
            list = headlist[j].childlist;
            if (headlist[j].data.equals(s)){
                for (int k = 0; k < list.size(); k++) {
                    n = (int) list.get(k).child;
                    queue.offer(headlist[n]);
                }
            }
        }
        while (!queue.isEmpty()){
            h = queue.poll();
            list= h.childlist;
            i += list.size();
        }
        return i;
    }
public void sumggson(String s){
        int result = sumggsonx(s);
    if (result != 0){
        System.out.println(result);
    }

}
    private int sumggsonx(String s){
        int i = 0,n,len;
        tLinkList<CTNode> list;
        HTNode h;
        Queue<HTNode> queue = new LinkedList<>();
        Queue<HTNode> queue2 = new LinkedList<>();
        for (int j = 0; j < headlist.length; j++) {
        list = headlist[j].childlist;
            if (headlist[j].data.equals(s)){
            for (int k = 0; k < list.size(); k++) {
                n = (int) list.get(k).child;
                queue.offer(headlist[n]);
            }
        }
    }
        while (!queue.isEmpty()){
         h = queue.poll();
            for (int j = 0; j < headlist.length; j++) {
                list = headlist[j].childlist;
                if (headlist[j].data.equals(h.data)){
                    for (int k = 0; k < list.size(); k++) {
                    n = (int) list.get(k).child;

                    queue2.offer(headlist[n]);
                }
            }
        }
    }
        while (!queue2.isEmpty()){
            h = queue2.poll();
            list= h.childlist;
            i += list.size();
        }
    return i;
    }



public void find(String s){
        ArrayList<Integer> list = new ArrayList<>();
        int index = -1,n;
        tLinkList<CTNode> clist;
    for (int i = 0; i <headlist.length ; i++) {
        if (headlist[i].data.equals(s)){
            index = i;
            break;
        }
    }
    list.add(index);
    while (index != 0) {
        for (int i = 0; i < headlist.length; i++) {
            clist = headlist[i].childlist;
            if (clist.size() != 0) {
                for (int j = 0; j < clist.size(); j++) {
                    n = (int) clist.get(j).child;
                    if (n == index) {
                        index = i;
                        list.add(index);
                        break;
                    }
                }
            }

        }
    }
    for (int i = list.size()-1; i >0 ; i--) {
        n = list.get(i);
        System.out.print(headlist[n].data+" ");
    }
}

public void maxleaves(){
        int max =0,maxt = 0;
        HTNode<String> p = new HTNode<>();
        tLinkList<CTNode> clist;
        int t;
    for (int i = 0; i < headlist.length; i++) {
        clist = headlist[i].childlist;
        for (int j = 0; j <clist.size() ; j++) {
            t = (int) clist.get(j).child;
            if (headlist[t].childlist.size() ==0){
                maxt++;
            }
        }
        if (maxt > max){
            max = maxt;
             p = headlist[i];
        }
        maxt = 0;
    }
    System.out.println(p.data+"人最多，有"+max+"人" );
}


public void destory(){
    tLinkList<CTNode> list;
    for (int i = 0; i <headlist.length ; i++) {
        list = headlist[i].childlist;
        for (int j = 0; j < list.size(); j++) {
            list.set(j,null);
        }
        headlist[i].childlist = null;
        headlist[i] = null;
    }
}
}
