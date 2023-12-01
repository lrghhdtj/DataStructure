package FinalExperiment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tranfifo {
    public static int SIZEOFDICT = 100;
    public static ArrayList<Word> dict_list = new ArrayList<>();
    public static Queue<Word> queue = new LinkedList<>();
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        Long strat_time= System.currentTimeMillis();
        read_dict();
        ArrayList<String> test_list = new ArrayList<>();
        test_list = read_test(test_list);
        for (int i = 0; i < SIZEOFDICT; i++) {
            queue.offer(dict_list.get(i));
            count ++;
        }









        Long end_time = System.currentTimeMillis();
        System.out.println("程序所用时间："+(end_time-strat_time));
    }
    public static void read_dict() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/dict.txt"));
        var line = reader.readLine();
        while (line != null){
            String []words = line.split(":");
            Word w = new Word(words[0],words[1] );
            dict_list.add(w);
            line = reader.readLine();
        }
        reader.close();
    }
    public static ArrayList<String> read_test(ArrayList<String> test_list) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/text.txt"));
        var line = reader.readLine();
        String regex = "[a-zA-Z]+";
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
    public static boolean unexit_dict(String s){
        for (int i = 0; i < dict_list.size(); i++) {
            if (dict_list.get(i).english.equals(s.toLowerCase())){
                return true;
            }
        }
        return false;
    }

}
