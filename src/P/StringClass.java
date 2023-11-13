package P;

public class StringClass {
    final int maxsize = 100;
    char [] data;
    int size;
    public StringClass(){
        data = new char[maxsize];
        size = 0;
    }

    public void setData(String s){
        char [] newdata = new char[maxsize];
        int newsize =0;
        if (size == maxsize){
            throw new IllegalArgumentException("字符长度超过上限！");
        }if (size > 0){
            for (int i = 0; i <s.length() ; i++) {
                newdata[i] = s.charAt(i);
                newsize++;
            }
            data = newdata;
            size = newsize;
        }else {
            for (int i = 0; i <s.length() ; i++) {
                data[i] = s.charAt(i);
                size++;
            }
        }
    }

    public void print(){
        String str = null;
        if (size == 0){
            System.out.println("null");
        }else {
            str = String.valueOf(data[0]);
            for (int i = 1; i < size; i++) {
                str += data[i];
            }
            System.out.println(str);
        }
    }

    public void maxlongstr(StringClass stringClass){
        char [] temnum = new char[3];
        char t = data[0];
        char longnum = 0;
        int longsize = 1 ,temsize =1;
        for (int i = 1; i <size ; i++) {
            if (t == data[i]){
                temsize++;
            }
            if (t != data[i]){
                t = data[i];
                longsize = temsize;
                temsize = 1;
            }
            if (temsize > longsize){
                longsize = temsize;
                longnum = t;
            }
            if(temsize == longsize){

            }
        }

            System.out.println("最长平台为：" + longnum + "，长度为：" +longsize);
    }




}
