package FinalExperiment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class generatedict {
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new FileReader("src/train.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/dict.txt",true));
        String regex = "[a-zA-Z]+";
        var line = in.readLine();
        Pattern pattern = Pattern.compile(regex);
        read_word();
        while (line != null){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String s = matcher.group();
                s = s.toLowerCase();
                if (unexit(s)){
                    System.out.println(s +",中文： ");
                    String c = sc.next();
                    s +=":" +c;
                    writer.write(s);
                    writer.newLine();
                    writer.flush();

                }
            }
            line = in.readLine();
        }
    }

    private static boolean unexit(String s) {
        if (list.contains(s)){
            return false;
        }else {
            return true;
        }
    }
    public static void read_word() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/dict.txt"));
        var line = reader.readLine();
        while (line != null){
            String []words = line.split(":");
            list.add(words[0].toLowerCase());
            line = reader.readLine();
        }
    }
}
