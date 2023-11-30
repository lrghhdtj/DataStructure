package tenth;

import java.util.HashSet;

public class task1 {
    public static void main(String[] args) {
        /*一个长度为L（L≥1）的升序序列S，处在第L/2个位置的数称为S的中位数。
        例如：若序列S1=(11，13，15，17，19)，则S1的中位数是15。
        两个序列的中位数是含它们所有元素的升序序列的中位数。
        例如，若S2=(2，4，6，8，20)，则S1和S2的中位数是11。
        现有两个等长升序序列A和B，试设计一个在时间和空间两方面都尽可能高效的算法，找出两个序列A和B的中位数。*/


        int [] a = {11,13,15,17,19};
        int [] b = {2,4,6,8,20};
        /*int[] a = {5, 12, 15, 21, 199};
        int[] b = {2, 9, 10, 16, 20};*/
        int size = a.length;
        int mid1 = 0, mid2 = 0;
        int l1 = 0, l2 = 0, h1 = size - 1, h2 = size - 1;
        while (l1 < h1 && l2 < h2) {
            mid1 = a[(l1 + h1) / 2];
            mid2 = b[(l2 + h2) / 2];
            if (mid1 == mid2) {
                System.out.println("序列A和B的中位数:" + mid1);
            } else {
                if (mid1 < mid2) {
                    if ((l1 + h1) % 2 == 0) {
                        l1 = (l1 + h1) / 2;
                    } else {
                        l1 = (l1 + h1) / 2 + 1;
                    }
                    h2 = (l2 + h2) / 2;
                } else {
                    if ((l2 + h2) % 2 == 0) {
                        l2 = (l2 + h2) / 2;
                    } else {
                        l2 = (l2 + h2) / 2 + 1;
                    }
                    h1 = (l1 + h1) / 2;
                }

            }
        }
        if (a[l1] > b[l2]) {
            System.out.println("序列A和B的中位数:" + mid2);
        } else {
            System.out.println("序列A和B的中位数:" + mid1);
        }
    }
}
