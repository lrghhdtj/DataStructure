package experiment6;


import java.util.ArrayList;
import java.util.Scanner;

public class demo {
    final static int N=45000;
    static int dp1[]=new int[N];
    static int dp2[]=new int[N];
    static int ans;
    static ArrayList<Node>[] g;
    public static void main(String[] args) {
        ans=0;
        for (int i = 0; i < N; i++) {
            dp1[i] = dp2[i] = 0;
        }
        g=new ArrayList[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<Node>();
        }
        int n,m;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int x,y,w;
            char d;
            x=scanner.nextInt();
            y=scanner.nextInt();
            w=scanner.nextInt();
            d=scanner.next().charAt(0);
            Node p=new Node(y,w);
            Node q=new Node(x,w);
            g[x].add(p);
            g[y].add(q);
        }
        dfs(1,-1);
        System.out.println(ans);
    }
    static class Node{
        int x,w;
        public Node(int x, int w){
            this.x=x;
            this.w=w;
        }
    }
    public static void dfs(int x,int y){
        for (int i = 0; i < g[x].size(); i++) {
            int son=g[x].get(i).x;
            int w=g[x].get(i).w;
            if(son==y) continue;
            dfs(son,x);
            if(dp1[x]<dp1[son]+w){
                dp2[x]=dp1[x];
                dp1[x]=dp1[son]+w;
            }else dp2[x]=Math.max(dp2[x],dp1[son]+w );
            ans=Math.max(ans,dp1[x]+dp2[x]);
        }
    }
}