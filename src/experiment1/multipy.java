package experiment1;
import java.util.Scanner;
public class multipy {
    public static String multipylongmun(String str1, String str2){
        int [] n = new int[str1.length()];
        int [] m = new int[str2.length()];
        int len = 0,t= 0;
        for (int i = 0; i <str2.length() ; i++) {
            m[i] =Integer.parseInt(String.valueOf(str2.charAt(i)));
        }
        for (int i = 0; i <str1.length() ; i++) {
            n[i] =Integer.parseInt(String.valueOf(str1.charAt(i)));
        }
        int [] result = new int[str1.length()+str2.length()-1];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < m.length; j++) {
                result[i+j] += n[i] * m[j];
            }
        }
        for (int i =result.length-1;i >0 ;i--){
            t = result[i] / 10;
            result[i-1] += t;
            result[i] = result[i] % 10;
        }
        String resultnum = String.valueOf(result[0]);
        for (int i = 1; i < result.length ; i++) {
            resultnum += result[i];
        }
        return resultnum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        multipy num = new multipy();
        String s = num.multipylongmun(str1,str2);
        System.out.println(s);
    }

}
