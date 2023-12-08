package FinalExperiment;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tranfifo {
    public static int SIZEOFDICT = 100;
    public static ArrayList<String> transform_list = new ArrayList<>();
    public static ArrayList<String> test_list = new ArrayList<>();
    public static LinkedList<Word> DICTLINER = new LinkedList<>();
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        Long strat_time= System.currentTimeMillis();
        read_dict();
        test_list = read_test(test_list);
        transfrom();
        print();
        Long end_time = System.currentTimeMillis();
        System.out.println("程序所用时间："+(end_time-strat_time)+"ms");
    }
    private static void read_dict() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/FinalExperiment/dict.txt"));
        var line = reader.readLine();
        while (line != null){
            String []words = line.split(":");
            Word w = new Word(words[0],words[1] );
                DICTLINER.offer(w);
                count ++;
                if (count == SIZEOFDICT-1){
                    break;
                }
            line = reader.readLine();
        }
        reader.close();
    }
    private static void print() {
        for (int i = 0; i < transform_list.size(); i++) {
            System.out.print(transform_list.get(i)+" ");
            if ((i % 15) ==0 && i != 0){
                System.out.println();
            }

        }
        System.out.println();
    }
    private static ArrayList<String> read_test(ArrayList<String> test_list) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/FinalExperiment/test.txt"));
        var line = reader.readLine();
        //String regex = "[a-zA-Z]+";
        String regex = "\\b[\\w'-]+\\b";
        Pattern pattern = Pattern.compile(regex);
        while (line != null){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String s = matcher.group().toLowerCase();
                test_list.add(s);
            }
            line = reader.readLine();
        }
        reader.close();
        return test_list;
    }
    private static void transfrom() throws IOException {
        for (int i = 0; i < test_list.size(); i++) {
            String s = test_list.get(i);
            if (unexitline(s.toLowerCase())){
                    updateline(s);
            }else {
                transform_list.add(transfromx(s.toLowerCase()));
            }
        }
    }
    private static boolean unexitline(String s){
        for (int i = 0; i < count; i++) {
            if (DICTLINER.get(i).english.equals(s)){
                return false;
            }
        }
        return true;
    }
    private static String transfromx(String s) {
        String c = "";
        for (int i = 0; i < count; i++) {
            String e = DICTLINER.get(i).getEnglish();
            if (e.equals(s)){
                c = DICTLINER.get(i).getChinese();
                break;
            }
        }
        return c;
    }
    private static void updateline(String s) throws IOException {
        Word w = findindict(s);
        if (w.english==null){
            transform_list.add(s);
        }else {
            transform_list.add(w.chinese);
            if (count == SIZEOFDICT){
                DICTLINER.pop();
                DICTLINER.offer(w);
            }else {
                DICTLINER.offer(w);
            }

        }
    }
    private static Word findindict(String s) throws IOException {
        Word w = new Word();
        BufferedReader reader = new BufferedReader(new FileReader("src/FinalExperiment/dict.txt"));
        var line = reader.readLine();
        while (line != null){
            String []words = line.split(":");
            if (words[0].equals(s)){
                w.setEnglish(words[0]);
                w.setChinese(words[1]);
            }
            line = reader.readLine();
        }
        reader.close();
            if (w != null){
                return w;
            }else {
                return null;
            }
    }
}