package experiment5;
import java.util.*;
public class Main {
    //POJ3253—围栏修复问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = 0;
        long  fee = 0,p,q;
        int[] num = new int[n];
        if (n <= 20000 && n >= 1) {
            while (t < n) {
                int len = sc.nextInt();
                num[t] = len;
                t++;
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i <num.length ; i++) {
            queue.offer(num[i]);
        }
        while (queue.size() >1){
            p = queue.peek();
            fee +=queue.poll();
            q =queue.peek();
            fee += queue.poll();
            queue.offer((int) (q+p));
        }
        System.out.println(fee);
    }

}

