package experiment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CTreeClass {
    HTNode [] headlist;
    public void create(unite [] r){
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
    Queue<String> queue = new LinkedList();
    for (int i = 0; i < headlist.length; i++) {
        queue.add(String.valueOf(headlist[i].data));
    }
    int n = 0;
    while (!queue.isEmpty()) {
        String s = queue.poll();
        tLinkList<CTNode> clist = new tLinkList<>();
        for (int i = 0; i < t.length; i++) {
            if (t[i].getName().equals(s)) {
                for (int j = 0; j < headlist.length; j++) {
                    if (t[i].getNextdep().equals(headlist[i].data)) {
                        CTNode<Integer> ctNode = new CTNode<>(i);
                        clist.add(ctNode);
                    }
                }
            }
        }
        headlist[n].firstchild = clist;
        n++;
    }
}

public void tostring(){
    for (int i = 0; i <headlist.length ; i++) {
        System.out.println(headlist[0].data+",");
        while (headlist[i].firstchild != null){
            tLinkList<CTNode> list =headlist[i].firstchild;
            CTNode p = list.head;
            while (p != null){
                System.out.println(headlist[(int) p.child]+",");
                p = p.next;
            }

        }
    }
}
public void sort(unite [] t){
    HashMap<String,ArrayList> listHashMap = new HashMap<>();
    for (int i = 0; i <t.length ; i++) {
        ArrayList<String> list = new ArrayList<>();
        for (int j = 0; j <t.length ; j++) {
            if (t[i].getName().equals(t[j].getNextdep())){
                list.add(t[j].getNextdep());
            }
        }
        listHashMap.put(t[i].getName(),list);
    }
    for (int i = 0; i < listHashMap.size(); i++) {
        System.out.println(listHashMap.get(headlist[i]));
    }
}
}
