package forth;

import P.StringClass;

public class task1 {
    //假设字符串s采用String对象存储。设计一个算法求s中最长平台，所谓平台是指连续相同字符。
    public static void main(String[] args) {
        StringClass stringClass = new StringClass();
        stringClass.setData("abc112222aaaaaa");
        stringClass.print();
        stringClass.maxlongstr(stringClass);
    }
}
