package sort;

/**
 * 快速排序 通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * <p/>
 * Created by yan on 2016/1/30.
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] sort = { 54, 31, 89, 33, 66, 12, 68, 20 };
        int[] sort = { 54, 11, 89, 33, 66, 12};
        System.out.print("排序前的数组为：");
        for (int data : sort) {
            System.out.print(data + " ");
        }
        System.out.println();
        quickSort(sort, 0, sort.length - 1);
        System.out.print("排序后的数组为：");
        for (int data : sort) {
            System.out.print(data + " ");
        }
    }
    /**
     * 快速排序
     * @param sort 要排序的数组
     * @param start 排序的开始座标
     * @param end 排序的结束座标
     */
    public static void quickSort(int[] sort, int start, int end) {
        // 设置关键数据key为要排序数组的第一个元素，
        // 即第一趟排序后，key右边的数全部比key大，key左边的数全部比key小
        int key = sort[start];
        // 设置数组左边的索引，往右移动判断比key大的数
        int i = start;
        // 设置数组右边的索引，往左移动判断比key小的数
        int j = end;
        // 如果左边索引比右边索引小，则还有数据没有排序
        while (i < j) {
            while (sort[j] > key && j > start) {
                j--;
            }
            while (sort[i] < key && i < end) {
                i++;
            }
            if (i < j) {
                int temp = sort[i];
                sort[i] = sort[j];
                sort[j] = temp;
            }
        }
        // 如果左边索引比右边索引要大，说明第一次排序完成，将sort[j]与key对换，
        // 即保持了key左边的数比key小，key右边的数比key大
        if (i > j) {
            int temp = sort[j];
            sort[j] = sort[start];
            sort[start] = temp;
        }
        //递归调用
        if (j > start && j < end) {
            quickSort(sort, start, j - 1);
            quickSort(sort, j + 1, end);
        }
    }

}
