package experiment6;

import P.AdjGraphClass;

public class task1 {
    public static void main(String[] args) {
        int INF  = 0x3f3f3f3f;
        int [][] graph ={
                {0,1,INF,1,INF,INF},
                {INF,0,1,INF,INF,INF},
                {1,INF,0,INF,INF,1},
                {INF,INF,1,0,INF,1},
                {INF,INF,INF,1,0,INF},
                {1,1,INF,1,1,0}
        };
        AdjGraphClass adjGraphClass = new AdjGraphClass();
        adjGraphClass.createAdjGraph(graph,6,12);
        adjGraphClass.printGraph();
        //（1）输出如图所示的有向图G从顶点5到顶点2的所有简单路径。
        System.out.println("顶点5到顶点2的所有简单路径:");
        adjGraphClass.findallway(5,2);
       //（2）输出如图所示的有向图G从顶点5到顶点2的所有长度为3的简单路径。
        System.out.println("5到顶点2的所有长度为3的简单路径:");
        adjGraphClass.findlengthway(5,2,3);
       //（3）输出如图所示的有向图G从顶点5到顶点2的所有最短路径。
        System.out.println("顶点5到顶点2的所有最短路径:");
        adjGraphClass.minway(5,2);


    }
}
