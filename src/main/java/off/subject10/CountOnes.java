package off.subject10;

/**
 * 快速计算二进制数中1的个数(Fast Bit Counting)
 * 该算法的思想如下：
 * 每次将该数与该数减一后的数值相与，从而将最右边的一位1消掉
 * 直到该数为0
 * 中间循环的次数即为其中1的个数
 * 例如给定"10100“，减一后为”10011",相与为"10000",这样就消掉最右边的1
 * Sparse Ones and Dense Ones were first described by Peter Wegner in
 * “A Technique for Counting Ones in a Binary Computer“,
 * Communications of the ACM, Volume 3 (1960) Number 5, page 322
 */
public class CountOnes {
    public static void main(String[] args) {
        int i = 7;
        CountOnes count = new CountOnes();
        System.out.println("There are " + count.getCount(i) + " ones in i");
    }
    /**
     * @author
     * @param i 待测数字
     * @return 二进制表示中1的个数
     */
    public int getCount(int i) {
        int n;
        for(n=0; i > 0; n++) {
            i &= (i - 1);
            System.out.println(i);
        }
        return n;
    }
}

