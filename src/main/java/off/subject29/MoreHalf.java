package off.subject29;

/**
 * 基于Java代码实现数字在数组中出现次数超过一半
 * 换个思路，这个可以通过计数实现，而不是真正物理删除。在遍历数组的过程中，保存两个值，
 * 一个是数组中数字，一个是出现次数。当遍历到下一个数字时，如果这个数字跟之前保存的数字相同，
 * 则次数加1，如果不同，则次数减1。如果次数为0，则保存下一个数字并把次数设置为1，
 * 由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
 * 那么要找的数字肯定是最后一次把次数设为1时对应的数字。
 * Created by yan on 2016/4/10.
 */
public class MoreHalf {

    public int doMoreHalf(int[] nums) {
        int result = 0;
        int count = 1;
        if (nums.length == 0)
            return -1;
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
                continue;
            }
            if (result == nums[i])
                count++;
            else
                count--;
        }
        return result;
    }

    public static void main(String args[]){
        int[] i = {1,2,3,2,2,2,5,4,2};
        System.out.println(new MoreHalf().doMoreHalf(i));
    }
}
