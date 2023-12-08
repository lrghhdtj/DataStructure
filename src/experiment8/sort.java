package experiment8;

public class sort {
    public static void main(String[] args) {
        //采用基数排序方法将一组英文单词按字典序排列。假设单词均由小写字母或空格构成，最长的单词有MaxLen个字母，用相关数据进行测试并输出各趟的排序结果。
        String[] words={"apple","happy","cat","abandon","dog"};
        System.out.print("排序前：");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]+" ");
        }
        System.out.println();
        System.out.print("排序后：");
        sortw(words);
    }
    private static void sortw(String[] words) {
        for (int i = 0; i < words.length -1; i++) {
            for (int j = words.length -1; j >i ; j--) {
                if (words[j-1].compareTo(words[j]) > 0) {
                    String t = words[j-1];
                    words[j-1] = words[j];
                    words[j] = t;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]+" ");
        }
    }
}
