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
                    System.out.printf("%4s","∞");
                }else {
                    System.out.printf("%5d",edges[i][j]);
                }
            }
            System.out.println();
        }
    }
    public void minway(int v, int t){
        int [] dist = new int[maxv];
        int [] path = new int[maxv];
        int [] s = new int[maxv];
        for (int i = 0; i <n ; i++) {
            dist[i] = edges[v][i];
            s[i] = 0;
            if (edges[v][i] < INF){
                path[i] = v;
            }else {
                path[i] = -1;
            }
        }
        s[v] = 1;
        int k =-1;
        int min;
        for (int i = 0; i <n-1 ; i++) {
            min = INF;
            for (int j = 0; j < n; j++) {
                if (s[j] == 0 && dist[j] < min){
                    k = j;
                    min = dist[j];
                }
            }
            s[k] = 1;
            for (int j = 0; j <n ; j++) {
                if (s[j] ==0){
                    if (edges[k][j] < INF && dist[k] + edges[k][j] <dist[j]) {
                        dist[j] = dist[k] + edges[k][j];
                        path[j] = k;
                    }
                }
            }
        }
        disppath(dist,path,s,v,t,n);
    }
    private void disppath(int[] dist, int[] path, int[] s, int v, int t, int n){
        int[] way = new int[maxv];
        int d;
        for (int i = 0; i < n; i++) {
            if (i == t) {
                System.out.println("顶点"+v + "到" + i + "的最小路径为" + dist[i]);
            }
            d =0;
            way[d] = i;
            int k= path[i];
            if (k == -1){
                System.out.println("无路径");
            }else {
                while (k !=v){
                    d++;
                    way[d] =k;
                    k = path[k];
                }
                d++;
                way[d] = v;
                for (int j =d; j >=0 ; j--) {
                    if (j == t){
                        System.out.print(" "+way[j]);
                    }

                }
            }
        }

    }
    public void Prim(int v){
        int [] lowcost = new int[maxv];
        int [] closest = new int[maxv];
        int min,k;
        for (int i = 0; i <n ; i++) {
            lowcost[i] = edges[v][i];
            closest[i] = v;
        }
        for (int i = 1; i < n; i++) {
            min = INF;
            k = -1;
            for (int j = 0; j < n; j++) {
                if (lowcost[j] != 0 && lowcost[j] < min){
                    min = lowcost[j];
                    k = j;
                }
            }
            System.out.print("(" + closest[k] + "," + k + "):" +min + " ");
            lowcost[k] = 0;
            for (int j = 0; j < n; j++) {
                if (lowcost[j] != 0 && edges[k][j] < lowcost[j]){
                    lowcost[j] = edges[k][j];
                    closest[j] = k;
                }
            }

        }
    }
}
