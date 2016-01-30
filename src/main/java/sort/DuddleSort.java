package sort;

import java.util.Random;

/**
 * 依次比较相邻的两个数，将小数放在前面，大数放在后面
 * 冒泡排序，具有稳定性
 * 时间复杂度为O（n^2）
 * 不及堆排序，快速排序O（nlogn，底数为2）
 * Created by yan on 2016/1/30.
 */
public class DuddleSort {
    public static void main(String[] args) {
        Random ran = new Random();
        int[] sort = new int[10];
        for(int i = 0 ; i < 10 ; i++){
            sort[i] = ran.nextInt(50);
        }
        System.out.print("排序前的数组为");
        for(int i : sort){
            System.out.print(i+" ");
        }
        buddleSort(sort);
        System.out.println();
        System.out.print("排序后的数组为");
        for(int i : sort){
            System.out.print(i+" ");
        }
    }

    /**
     * 冒泡排序
     * @param sort
     */
    private static void buddleSort(int[] sort){
        for(int i=1;i<sort.length;i++){
            for(int j=0;j<sort.length-i;j++){
                if(sort[j]>sort[j+1]){
                    int temp = sort[j+1];
                    sort[j+1] = sort[j];
                    sort[j] = temp;
                }
            }
        }
    }

}
