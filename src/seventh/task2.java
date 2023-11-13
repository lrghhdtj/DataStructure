package seventh;

import P.AdjGraphClass;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class task2 {
    public static void main(String[] args) {
        // 一个图G采用邻接表作为存储结构。设计一个算法判断顶点i到顶点j是否存在不包含顶点k的路径（假设i、j、k都是G中的顶点并且不相同）。
        AdjGraphClass adjGraphClass = new AdjGraphClass();
        int [][] a = {
                {0,1,0,1,1},
                {1,0,1,1,0},
                {0,1,0,1,1},
                {1,1,1,0,1},
                {1,0,1,1,0}
        };
        adjGraphClass.createAdjGraph(a,5,7);
        adjGraphClass.printGraph();
        uncontaink(adjGraphClass,1,2,3);
    }
    static int[] visited = new int[100];
    public static void uncontaink(AdjGraphClass g,int i, int j,int k){
        Arrays.fill(visited,0);
        if (uncontain(g,i,j,k)){
            System.out.println(i+"到"+j+"路径不包含"+k);
        }else {
            System.out.println(i+"到" +j+"路径包含"+k);
        }
    }
    private static boolean uncontain(AdjGraphClass g ,int a,int b,int k){
        AdjGraphClass.ArcNode p;
        int t;
        visited[a] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        while (!queue.isEmpty()){
            a = queue.poll();
            p = g.adjlist[a].firstarc;
            while (p != null){
                t= p.adjvex;
                if (t == k){
                    return false;
                }else {
                    if (visited[t] == 0) {
                        if (t == b) {
                            break;
                        }
                        visited[t] = 1;
                        queue.offer(t);
                    }
                    p = p.nextarc;
                }
            }
        }
        return true;
    }
}