package P;

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
    final int maxv = 100;
    final int INF  = 0x3f3f3f3f;
    public VNode[] adjlist;
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
    public void minway(int s,int t){

    }

}
