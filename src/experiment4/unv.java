package experiment4;

import P.SonTree.CTreeClass;

import java.io.*;
import java.util.ArrayList;

public class unv {
    public static void main(String[] args) throws IOException {
        //(1) 从abc.txt文件读数据到R数组中；
        BufferedReader in = new BufferedReader(new FileReader("D:\\create\\IDEA\\IntelliJ IDEA 2023.1.2\\products\\DataStructure\\src\\src\\experiment4\\abc.txt"));
        var aline = in.readLine();
        String n [];
        ArrayList<unite> list = new ArrayList<>();
        while (aline != null){
            n = aline.split("[:]");
            unite u = new unite();
            u.setName(n[0].trim());
            u.setNextdep(n[1].trim());
            list.add(u);
            aline = in.readLine();
        }
        in.close();
        unite [] R = new unite[list.size()];
        for (int i = 0; i < list.size(); i++) {
            R[i] = list.get(i);
        }
        //(2) 由数组R创建树t的孩子链存储结构；
        CTreeClass cTreeClass = new CTreeClass();
        cTreeClass.create(R);
        //(3) 采用括号表示法输出树T；
        cTreeClass.tostring();
        //(4) 求计算机学院的专业数；
        System.out.print("计算机学院的专业数；");
        cTreeClass.sumson("计算机学院");
        //(5) 求计算机学院的班数；
        System.out.print("计算机学院的班数:");
        cTreeClass.sumgson("计算机学院");
        //(6) 求电信学院的学生数；
        System.out.print("电信学院的学生数:");
        cTreeClass.sumggson("电信学院");
        //(7) 求韩愈在哪所学校、哪个学院、哪个专业、哪个班（可选）；
        cTreeClass.find("韩愈");
        //(8) 求哪个班级人数最多（可选）；
        System.out.println();
        cTreeClass.maxleaves();
        //(9) 销毁树。
        cTreeClass.destory();
    }
}
