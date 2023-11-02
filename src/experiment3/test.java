package experiment3;
import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (true) {
            if (n == 0) {
                break;
            }
            String num = sc.next();
            if (num.equals("0")) {
                n = sc.nextInt();
                continue;
            }
            if (n != num.length()) {
                System.out.println("No");
                continue;
            }
            boolean result = stacktrain(num);
            if (result) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean stacktrain(String s) {
        Stack stack = new Stack<String>();
        String[] a = new String[s.length()];
        String[] b = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = String.valueOf(i + 1);
            b[i] = String.valueOf(s.charAt(i));
        }
        int i = 0, j = 0;
        while (i < s.length()) {
            stack.push(a[i]);
            i++;
            while (!stack.empty() &&stack.peek().equals(b[j])){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}