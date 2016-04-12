package off.subject8;


/**
 * http://bylijinnan.iteye.com/blog/1431531
 * 题目：旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们
 * 称之为数组的旋转。输入递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。
 *
 * @author solomon
 */

public class MinOfShiftedArray {
 /*
 * 传进去旋转数组，注意旋转数组的特性：
 * 1.包含两个有序序列
 * 2.最小数一定位于第二个序列的开头
 * 3.前序列的值都>=后序列的值
 * 定义把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * ^_^这个旋转思想是很经典的
 * 旋转数组实例：
 * {123456}旋转后{456123}
 */

    public static int minNumberInRotateArray(int [] array) {
        if (array != null && array.length > 0) {
            int index1 = 0;
            int index2 = array.length - 1;
            int indexMid = index1;

            while (array[index1] >= array[index2]) {

                if(index2 - index1 ==1){
                    indexMid = index2;
                    break;
                }

                indexMid = (index1 + index2) / 2;

                if (array[indexMid] >= array[index1]) {
                    index1 = indexMid;
                }else if(array[indexMid] <= array[index2]){
                    index2 = indexMid;
                }

            }

            return array[indexMid];
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] a={
                {1,2,3,4,5},
                {2,3,4,5,1},
                {3,4,5,1,2},
                {4,5,1,2,3},
                {5,1,2,3,4},
        };
        for(int[] each:a){
            int min=minNumberInRotateArray(each);
            System.out.println(min);
        }

    }

}


