package eighth;
import java.util.Scanner;
public class Main {
    final static int maxv = 1000;
    final static int INF  = 0x3f3f3f3f;
    static int [] [] edges = new int[maxv][maxv];
    static int [] lowcost = new int[maxv];
    static int [] closest = new int[maxv];
    static int n;
    static class  point{
        public int x,y;
        public point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        point[] location=new point[maxv];
         n = sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            int x =sc.nextInt();
            int y = sc.nextInt();
            location[i]=new point(x,y);
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <i ; j++) {
                edges[i][j] = edges[j][i] =
                        (location[i].x - location[j].x) * (location[i].x - location[j].x) + (location[i].y - location[j].y) * (location[i].y - location[j].y);
            }
            edges[i][i] =INF;
        }
        int m = sc.nextInt();
        for (int i = 1; i <=m ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[x][y] = edges[y][x] = 0;
        }
        Prim();
    }
    public static void Prim(){
        int min,k = 0;
        for (int i = 1; i <=n ; i++) {
            lowcost[i] = edges[1][i];
            closest[i] = 1;
        }
        lowcost[1] = -1;
        for (int i = 1; i < n; i++) {
            min = INF;
            for (int j = 1; j <= n; j++) {
                if (lowcost[j] != -1 && lowcost[j] < min) {
                    min = lowcost[j];
                    k = j;
                }
            }
            if (lowcost[k] !=0) {
                System.out.println(closest[k] + " " + k);
            }
            lowcost[k] = -1;
            for (int j = 1; j <=n; j++) {
                if (lowcost[j] != -1 && edges[k][j] < lowcost[j]){
                    lowcost[j] = edges[k][j];
                    closest[j] = k;
                }
            }
        }
    }
}
/*
9
1 5
0 0
3 2
4 5
5 1
0 4
5 2
1 2
5 3
3
1 3
9 7
1 2
        */

/*
1 6
3 7
4 9
5 7
8 3*/
