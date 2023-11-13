package seventh;

import P.MatGraphClass;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class task1 {
    public static void main(String[] args) {
        //一个图G采用邻接矩阵作为存储结构，设计一个算法采用广度优先遍历判断顶点i到顶点j是否有路径（假设顶点i和j都是G中的顶点）
        MatGraphClass matGraphClass = new MatGraphClass();
        int [][] a = {
                {0,1,0,1,1},
                {1,0,1,1,0},
                {0,1,0,1,1},
                {1,1,1,0,1},
                {1,0,1,1,0}
        };
        matGraphClass.CreateMatGraph(a,5,7);
        matGraphClass.printMatGraph();
        findway(matGraphClass,1,3);
    }
    static int[] visited = new int[100];
    public static void findway(MatGraphClass g ,int a,int b){
        Arrays.fill(visited,0);
        if (findwayx(g,a,b)){
            System.out.println(a+"到"+b+"有路径");
        }else {
            System.out.println(a+"到" +b+"无路径");
        }
    }
    private static boolean findwayx(MatGraphClass g, int a, int b){
        Queue<Integer> queue = new LinkedList<>();
        visited[a] = 1;
        queue.offer(a);
        int t ;
        while (!queue.isEmpty()){
            t = queue.poll();
            for (int i = 0; i <g.n ; i++) {
                if (g.edges[t][i] != 0 && g.edges[t][i] != g.INF){
                    if (visited[i] == 0) {
                        if (i == b){
                            return true;
                        }
                        visited[i] = 1;
                        queue.offer(i);
                    }
                }
            }
        }
        return false;
    }

}