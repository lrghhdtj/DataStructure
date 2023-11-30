package FinalExperiment;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class generatedict {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new FileReader("src\\FinalExperiment\\train.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\FinalExperiment\\dict.txt",true));
        String regex = "[a-zA-Z]+";
        var line = in.readLine();
        Pattern pattern = Pattern.compile(regex);
        writer.write("123");
        writer.newLine();
        /*while (line != null){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String s = matcher.group();
                if (unexit(s)){
                    System.out.println(s +",中文： ");
                    String c = sc.next();
                    s +=":" +c;
                    writer.write(s);

                }
            }
            line = in.readLine();
        }*/

    }
    public static boolean unexit(String english) throws FileNotFoundException {
        BufferedReader out = new BufferedReader(new FileReader("src\\FinalExperiment\\dict.txt"));
        return true;
    }
}
