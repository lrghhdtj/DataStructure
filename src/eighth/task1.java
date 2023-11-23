package eighth;

import P.MatGraphClass;

public class task1 {
    public static void main(String[] args) {
        //假设一个带权图G采用邻接矩阵存储。设计一个算法采用狄克斯特拉算法思路求顶点s到顶点t的最短路径长度（假设顶点s和t都是G中的顶点）。
        MatGraphClass matGraphClass = new MatGraphClass();
        int INF  = 0x3f3f3f3f;
        int [][] a = {
                {0,8,INF,5,INF},
                {INF,0,3,INF,INF},
                {INF,INF,0,INF,6},
                {INF,INF,9,0,INF},
                {INF,INF,INF,INF,0}
        };
        matGraphClass.CreateMatGraph(a,5,7);
        matGraphClass.printMatGraph();
        matGraphClass.dijkstra(0,4);

    }
}
