package experiment4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class unv {
    public static void main(String[] args) throws IOException {
        //(1) 从abc.txt文件读数据到R数组中；
        ArrayList<poj> list = new ArrayList<>();
       FileReader fileReader = new FileReader("D:\\create\\IDEA\\IntelliJ IDEA 2023.1.2\\products\\DataStructure\\src\\src\\experiment4\\abc.txt");
       BufferedReader in = new BufferedReader(fileReader);
       var aline = in.readLine();
       while (aline != null){
           poj p =  new poj();
           String s = Arrays.toString(aline.split("[:]"));
          /* p.setName();
           p.setNextdep();*/
           list.add(p);
           aline = in.readLine();
       }
       in.close();
        poj [] R = new poj[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            R[i] = list.get(i);
            System.out.println(R[i].getName()+":"+R[i].getNextdep());
        }
        //(2) 由数组R创建树t的孩子链存储结构；

        //(3) 采用括号表示法输出树T；

        //(4) 求计算机学院的专业数；

        //(5) 求计算机学院的班数；

        //(6) 求电信学院的学生数；

        //(7) 求韩愈在哪所学校、哪个学院、哪个专业、哪个班（可选）；

        //(8) 求哪个班级人数最多（可选）；

        //(9) 销毁树。
    }
}
