package experiment4;

import java.io.*;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("D:\\create\\IDEA\\IntelliJ IDEA 2023.1.2\\products\\DataStructure\\src\\src\\experiment4\\abc.txt"));
        var aline = in.readLine();
        String n [];
        while (aline != null){
            n = aline.split("[:]");
            for (int i = 0; i <n.length ; i++) {
                System.out.println(n[0]);
            }
            aline = in.readLine();
        }
    }
}
