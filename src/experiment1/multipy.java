package experiment1;
public class multipy {
    public void multipylongmun(String str1,String str2){
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
        for (int num:n) {
            System.out.print(num);
        }System.out.println();
        for (int num:m) {
            System.out.print(num);
        }System.out.println();
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
        for (int num:result) {
            System.out.print(num+"");
        }

    }


}
