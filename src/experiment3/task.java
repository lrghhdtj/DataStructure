package experiment3;
import P.QueueClass;

import java.util.Scanner;
public class task {
    public static void main(String[] args) {
        QueueClass queueClass = new QueueClass<Integer>();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入下列您要操作的序号：");
            System.out.println("1、排队  2、就诊  3、查看排队  4、不再排队  5、下班");
            int t = sc.nextInt();
            switch (t){
                case 1:  {
                    System.out.println("请输入病历号：");
                    int num= sc.nextInt();
                    queueClass.push(num);
                    break;
                }
                case  2 : {
                    int n = (int) queueClass.pop();
                    System.out.println(n + "号病人就诊");
                    break;
                }
                case  3 :{
                    queueClass.print();
                    break;
                }
                case 4 :{
                    while (!queueClass.empty()){
                        System.out.println(queueClass.pop());
                    }
                    System.exit(0);
                }
                case 5 :{
                    System.exit(0);
                    break;
                }
                default: System.out.println("输入序号无效！");
            }
        }
    }
}
