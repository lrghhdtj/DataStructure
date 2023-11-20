package eighth;

import P.MatGraphClass;

public class task1 {
    public static void main(String[] args) {
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
        matGraphClass.minway(0,4);

    }
}
