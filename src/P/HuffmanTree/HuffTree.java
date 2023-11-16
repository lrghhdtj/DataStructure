package P.HuffmanTree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffTree {
    final int Maxn = 100;
    double [] w;
    String str;
    int num;
    HuffTNode [] ht;
    String [] hcd;
    public HuffTree(){
        ht = new HuffTNode[Maxn];
        hcd = new String[Maxn];
        w = new double[Maxn];
    }
    public void setdata(int num,double[] w,String str){
        this.num = num;
        for (int i = 0; i <num ; i++) {
            this.w[i] = w[i];
            this.str = str;
        }
    }
    public void CreateHt(){
        Comparator<HuffTNode> priComparator = new Comparator<HuffTNode>() {
            @Override
            public int compare(HuffTNode o1, HuffTNode o2) {
                return (int)(o1.getWeight()-o2.getWeight());
            }
        };
        PriorityQueue<HuffTNode> queue = new PriorityQueue<>(Maxn,priComparator);
        for (int i = 0; i <num ; i++) {
            ht[i] = new HuffTNode();
            ht[i].parent = null;
            ht[i].data = str.charAt(i);
            ht[i].weight = w[i];
            queue.offer(ht[i]);
        }
        for (int i = num; i < (2 * num -1); i++) {
            HuffTNode p1 = queue.poll();
            HuffTNode p2 = queue.poll();
            ht[i] = new HuffTNode();
            p1.parent = ht[i];
            p2.parent = ht[i];
            ht[i].weight = p1.weight + p2.weight;
            ht[i].lchild = p1;
            p1.flag = true;
            ht[i].rchild = p2;
            p2.flag = false;
            queue.offer(ht[i]);
        }

    }
    private String reverse(String s){
        String t = "";
        for (int i = s.length()-1; i >= 0 ; i++) {
            t += s.charAt(i);
        }
        return t;
    }
    public void CreateHcode(){
        for (int i = 0; i <num ; i++) {
            hcd[i] = "";
            HuffTNode p = ht[i];
            while (p .parent != null){
                if (p.flag){
                    hcd[i] += '0';
                }else {
                    hcd[i] += '1';
                }
                p = p .parent;
            }
            System.out.println("hcd:"+hcd[i]);
            hcd[i] = reverse(hcd[i]);
        }
    }
    public void DispHuffman(){
        for (int i = 0; i <num ; i++) {
            System.out.println(ht[i].data+" "+hcd[i]);
        }
    }
}
