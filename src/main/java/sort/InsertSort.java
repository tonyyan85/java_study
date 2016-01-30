package sort;

import java.util.Random;

/**
 * 直接插入排序
 * 将一个数据插入到已经排好序的有序数据中,从而得到一个新的、个数加一的有序数据
 * 算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
 *
 * Created by yan on 2016/1/30.
 */
public class InsertSort {

    public static void main(String[] args) {
        Random ran = new Random();
        int[] sort = new int[10];
        for (int i = 0; i < 10; i++) {
            sort[i] = ran.nextInt(50);
        }
        System.out.print("排序前的数组为");
        for (int i : sort) {
            System.out.print(i + " ");
        }
        directInsertSort(sort);
        System.out.println();
        System.out.print("排序后的数组为");
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }
    /**
     * 直接插入排序
     *
     * @param sort
     */
    private static void directInsertSort(int[] sort) {
        for (int i = 1; i < sort.length; i++) {
            int index = i - 1;
            int temp = sort[i];
            while (index >= 0 && sort[index] > temp) {
                sort[index + 1] = sort[index];
                index--;
            }
            sort[index + 1] = temp;
        }
    }
}
