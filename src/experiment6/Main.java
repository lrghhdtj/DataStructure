package experiment6;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int [] [] a ;
        //POJ 1985
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n][n];
        int []dist = new int[n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int l = sc.nextInt();
            a [x-1][y-1] = l;
            String location = sc.next();
        }
        Dfs(a,n,dist);
    }
    static int maxway = 0;
    public static void Dfs(int [][]a,int n,int [] dist){
        for (int v = 0; v < n; v++) {
            maxway = Math.max(maxway,Dfsx(a,v,n,dist));
        }
        System.out.println(maxway);
    }

    private static int Dfsx(int[][] a, int v, int n ,int[] dist) {
        if (dist[v] > 0){
            return dist[v];
        }
        for (int w = 0; w <n ; w++) {
            if (a[v][w] != 0 && a[v][w] > 0){
                dist[v] = Math.max(dist[v], Dfsx(a, w, n, dist) + a[v][w]);
            }
        }
        return dist[v];
    }
}
/*
7 6
1 6 13 E
6 3 9 E
3 5 7 S
4 1 3 N
2 4 20 W
4 7 2 S
*/
