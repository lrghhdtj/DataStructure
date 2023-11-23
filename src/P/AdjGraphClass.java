package P;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AdjGraphClass {
    public class ArcNode{
        public int adjvex;
        public ArcNode nextarc;
        int weight;
    }
    public class VNode{
        String [] data;
        public ArcNode firstarc;
    }
    class Node{
        int i;
        int dist;
        public Node(int i ,int dist ){
            this.i = i;
            this.dist = dist;
        }
    }

    final int maxv = 100;
    final int INF  = 0x3f3f3f3f;
    public VNode[] adjlist;
    int [] visited = new int[maxv];
    int n,e;
    public AdjGraphClass(){
        adjlist = new VNode[maxv];
        for (int i = 0; i <maxv ; i++) {
            adjlist[i] = new VNode();
        }
    }
    public void createAdjGraph(int [] [] a,int n,int e){
        this.n = n;
        this.e = e;
        ArcNode p;
        for (int i = 0; i <n ; i++) {
            adjlist[i].firstarc = null;
        }
        for (int i = 0; i <n ; i++) {
            for (int j = n-1; j >=0 ; j--) {
                if (a[i][j] != 0 && a[i][j] != INF){
                    p = new ArcNode();
                    p.adjvex = j;
                    p.weight = a[i][j];
                    p.nextarc = adjlist[i].firstarc;
                    adjlist[i].firstarc = p;
                }
            }
        }
    }
    public void printGraph(){
        ArcNode p;
        for (int i = 0; i <n ; i++) {
            System.out.print(i+" ");
            p= adjlist[i].firstarc;
            while (p != null){
                System.out.printf("->(%d,%d)",p.adjvex,p.weight);
                p = p.nextarc;
            }
            System.out.println();
        }
    }
    public int dijkstra(int u, int v){
        Comparator<Node> nodeComparator = (o1, o2) -> (o2.dist - o1.dist);
        PriorityQueue<Node> queue = new PriorityQueue<>(maxv,nodeComparator);
        int [] len = new int[maxv];
        int [] S = new int[maxv];
        Node e;
        ArcNode p;
        Arrays.fill(len,INF);
        p = adjlist[u].firstarc;
        while (p != null){
            int w = p.adjvex;
            len[w] = p.weight;
            if (p.weight <INF){
                //path[]
            }
            queue.offer(new Node(w,len[w]));
            p = p.nextarc;
        }
        S[u] = 1;
        for (int i = 0; i < n-1; i++) {
            int t = queue.poll().i;
            if (S[t] == 1) {
                continue;
            }
            S[t] = 1;
            p = adjlist[t].firstarc;
            while (p != null) {
                int w = p.adjvex;
                if (S[w] == 0) {
                    if (len[t] + p.weight < len[w]) {
                        len[w] = len[t] + p.weight;
                        queue.offer(new Node(w, len[w]));
                    }
                }
                p = p.nextarc;
            }
        }
     return len[v];

    }
    public void haspath (int u ,int v){
        Arrays.fill(visited,0);
        if (haspathx(u,v)){
            System.out.println("有路径");
        }else {
            System.out.println("无路径");
        }
    }

    private boolean haspathx(int u, int v) {
        ArcNode p;
        int w;
        visited[u] = 1;
        p = adjlist[u].firstarc;
        while (p != null){
            w = p.adjvex;
            if (w == v){
                return true;
            }
            if (visited[w] == 0){
                if (haspathx(w,v)){
                    return true;
                }
            }
            p = p.nextarc;
        }

        return false;
    }
    public void findallway(int u,int v){
        int [] path = new int[maxv];
        int d =-1;
        Arrays.fill(visited,0);
        findallwayx(u,v,path,d);
    }

    private void findallwayx(int u, int v,int [] path,int d) {
        ArcNode p;
        visited[u] = 1;
        d++;
        path[d] = u;
        if (u == v){
            for (int i = 0; i <= d; i++) {
                    System.out.print(path[i] + " ");
            }
            System.out.println();
            visited[u] =0;
            return;
        }
        p = adjlist[u].firstarc;
        while (p != null){
            int w = p.adjvex;
            if (visited[w] ==0){
                findallwayx(w,v,path,d);
            }
            p = p.nextarc;
        }
        visited[u] = 0;
    }
    public void findlengthway(int u,int v,int l){
        int [] path = new int[maxv];
        int d = -1;
        Arrays.fill(visited,0);
        findlengthwayx(u,v,l,path,d);
    }

    private void findlengthwayx(int u, int v, int l, int[] path, int d) {
        ArcNode p;
        visited[u] = 1;
        d++;
        path[d] = u;
        if (u == v && d == l){
            for (int i = 0; i <= d ; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            visited[u] = 0;
            return;
        }
        p = adjlist[u].firstarc;
        while (p != null){
            int w = p.adjvex;
            if (visited[w] ==0){
                findlengthwayx(w,v,l,path,d);
            }
            p = p.nextarc;
        }
        visited[u] = 0;
    }
    public void minway(int u, int v){
        minwayx(u,v);
    }

    private void minwayx(int u, int v) {
       int t = dijkstra(u,v);
       findlengthway(u,v,t);
    }

}
