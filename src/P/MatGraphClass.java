package P;

public class MatGraphClass {
    final int maxv = 100;
    public final int INF  = 0x3f3f3f3f;
    public int [] [] edges;
    public int n;
    int e;
    String []vexs;
    public MatGraphClass(){
        edges = new int[maxv][maxv];
        vexs = new String[maxv];
    }
    public void CreateMatGraph(int [] [] a,int n ,int e){
        this.n = n;
        this.e = e;
        for (int i = 0; i <n ; i++) {
            edges[i] = new int[n];
            for (int j = 0; j <n ; j++) {
                edges[i][j] = a[i][j];
            }
        }
    }
    public void printMatGraph(){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (edges[i][j] == INF){
                    System.out.printf("%4s","*");
                }else {
                    System.out.printf("%5d",edges[i][j]);
                }
            }
            System.out.println();
        }
    }

}
