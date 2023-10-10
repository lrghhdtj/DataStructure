package third;

public class task1 {
    public static boolean ismatch(String str){
        StackClass<Character> stackClass = new StackClass<>();
        int i = 0;
        if (str == null || str.length() ==0) {
            throw new IllegalArgumentException("字符串为空！");
        }else {
            while (i < str.length()/2 ) {
                stackClass.push(str.charAt(i));
                i++;
            }
            if (str.charAt(i) != '@' || i % 2 !=0 ) {
                return false;
            }else {
                i++;
                while (i <str.length()){
                    if (str.charAt(i) != stackClass.pop()){
                        return false;
                    }else {
                        i++;
                    }
                }
            }
        }
        return true;
    }
    //给定一个字符串str。设计一个算法采用顺序栈判断str是否为形如“序列1@序列2”的合法字符串，其中序列2是序列1的逆序，str中恰好只有一个@字符。
    public static void main(String[] args) {
        String []list =new String[4];
        list[0]= "ab@ba";
        list[1]= "abba";
        list[2]= "ab@bac";
        list[3]=  "ab@ab";
        for (int i = 0; i < list.length; i++) {
            if (ismatch(list[i])){
                System.out.println(list[i] + "是序列1@序列2”的合法字符串");
            }else {
                System.out.println(list[i] + "不是序列1@序列2”的合法字符串");
            }
        }
        System.out.println("其中序列2是序列1的逆序");
    }
}
