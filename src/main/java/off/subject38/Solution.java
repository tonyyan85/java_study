package off.subject38;

/**
 * 题目：

 统计一个数字在排序数组中出现的次数，例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4.
 1
 解题思路：

 最容易想到的肯定就是二分查找了，在题目给出的例子中，我们可以先用二分查找算法找到一个3，由于我们找到的3的左右两边都有3，于是我们在找到的3的左右两边分别进行扫描，将扫描到的3的个数分别相加即可，此算法的复杂度为O（n）。接下来介绍复杂度为O（logn）的算法

 在二分查找的基础上，我们想要更加优化时间复杂度，在题目给出的例子中，我们可以先用二分查找算法找到一个3，然后比较3前面的数字是否为3，如果为3，那么第一次出现3的位置在数组前半段，对前半段进行二分查找。再比较3后面的数字是否为3，如果为3，那么最后一次出现3的位置肯定在数组的后半段，对后半段进行二分查找。最后可以得到3第一次出现和最后一次出现的位置，3的次数便可以计算出来，算法如下
 */
public class Solution {

    public static void main (String args[]){
        int[] array = {1,5,6,7,8,8,9};
        int k =8;
        System.out.println(new Solution().GetNumberOfK(array,k));
    }

    public int GetNumberOfK(int [] array , int k) {
        int firstK = getFirstK(array,k,0,array.length-1);
        int lastK = getLastK(array,k,0,array.length-1);
        if(firstK==-1&&lastK==-1)
            return 0;
        return lastK - firstK + 1;
    }

    public int getFirstK(int[] array,int k,int low,int high){
        if(array==null)
            return 0;
        if(low>high){
            return -1;
        }
        int result = -1;
        int middle = (low+high)/2;
        if(array[middle]==k){
            if(middle==low){
                return middle;
            }
            if(array[middle-1]==k){
                high = middle-1;
            }else{
                return middle;
            }
        }else if(array[middle]>k){
            high = middle-1;
        }else{
            low = middle+1;
        }
        result = getFirstK(array,k,low,high);
        return result;
    }

    public int getLastK(int[] array,int k,int low,int high){
        if(array==null)
            return 0;
        if(low>high){
            return -1;
        }
        int result = -1;
        int middle = (low+high)/2;
        if(array[middle]==k){
            if(middle==high){
                return middle;
            }
            if(array[middle+1]==k){
                low = middle+1;
            }else{
                return middle;
            }
        }else if(array[middle]>k){
            high = middle-1;
        }else{
            low = middle+1;
        }
        result = getLastK(array,k,low,high);
        return result;
    }

}
