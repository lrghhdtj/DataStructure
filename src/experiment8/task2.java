package experiment8;

import java.util.Arrays;
import java.util.Comparator;

public class task2 {

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        //int [][]points ={{1,3},{-2,2}};
        int k = 2;
        //int k = 1;
        closest(points, k);

    }

    private static void closest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= 1; j++) {
                System.out.print(points[i][j]+" ");
            }
            System.out.println();
        }
    }






    //points = [[3,3],[5,-1],[-2,4]], k = 2
    //points = [[1,3],[-2,2]], k = 1
}
