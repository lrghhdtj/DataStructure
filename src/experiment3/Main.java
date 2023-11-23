package experiment3;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    //poj1363 Rails
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n !=0) {
            int num =sc.nextInt();
            while (num !=0) {
                Integer[] t  = new Integer[n];
                t[0] = num;
                for (int i = 1; i < n; i++) {
                    t[i] = sc.nextInt();
                }
                if (stacktrain(t)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
                num = sc.nextInt();
                if (num ==0){
                    System.out.println();
                }
            }
            n = sc.nextInt();
            if (n == 0){
                break;
            }

        }


    }
    public static boolean stacktrain(Integer[] t) {
        Stack<String> stack = new Stack<String>();
        String[] a = new String[t.length];
        String[] b = new String[t.length];
        for (int i = 0; i < t.length; i++) {
            a[i] = String.valueOf(i + 1);
            b[i] = String.valueOf(t[i]);
        }
        int i = 0, j = 0;
        while (i <t.length) {
            stack.push(a[i]);
            i++;
            while (!stack.empty() && stack.peek().equals(b[j])){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}