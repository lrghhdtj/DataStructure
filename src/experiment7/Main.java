package experiment7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //POJ2785—总和为零的四元组数
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            A[i] = a;
            int b = sc.nextInt();
            B[i] = b;
            int c = sc.nextInt();
            C[i] = c;
            int d = sc.nextInt();
            D[i] = d;
        }
        int []list1 = new int[n*n];
        int []list2 = new int[n*n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list1[count] = A[i] + B[j];
                list2[count] = C[i] + D[j];
                count++;
            }
        }
        Arrays.sort(list2);
        for (int i = 0; i < count; i++) {
            int low = 0;
            int high = count - 1;
            int mid;
            while (high >= low){
                mid = low + (high - low) / 2;
                if (list1[i] + list2[mid] == 0){
                    for (int j = low; j <= high; j++) {
                        if (list2[mid] == list2[j]){
                            sum++;
                        }
                    }
                    break;
                }
                if (list1[i] + list2[mid]<0){
                    low = mid +1;
                }else {
                    high = mid -1;
                }
            }
        }
        System.out.println(sum);
    }
}
 /*
6
-45 22 42 -16
-41 -27 56 30
-36 53 -37 77
-36 30 -75 -46
26 -38 -10 62
-32 -54 -6 45
*/

/*
4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
*/
