package sort;

import java.util.Random;

/**
 *
 * 选择排序
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，
 * 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
 * 选择排序是不稳定的排序方法。
 * Created by yan on 2016/1/30.
 */
public class SelectSort {

    public static void main(String[] args) {
        Random ran = new Random();
        int[] sort = new int[10];
        for (int i = 0; i < 10; i++) {
            sort[i] = ran.nextInt(50);
        }
        System.out.print("排序前的数组为");
        System.out.println();
        for (int i : sort) {
            System.out.print(i + " ");
        }
        selectSort(sort);
        System.out.println();
        System.out.print("排序后的数组为");
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }
    /**
     * 选择排序
     * @param sort
     */
    private static void selectSort(int[] sort){
        for(int i =0;i<sort.length-1;i++){
            for(int j = i+1;j<sort.length;j++){
                if(sort[j]<sort[i]){
                    int temp = sort[j];
                    sort[j] = sort[i];
                    sort[i] = temp;
                }
            }
            for(int s : sort){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
