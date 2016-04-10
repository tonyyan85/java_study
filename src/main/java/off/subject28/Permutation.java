package off.subject28;

/**
 * 如果能生成n-1个元素的全排列，就能生成n个元素的全排列。对于只有一个元素的集合，可以直接生成全排列。所以全排列的递归终止条件很明确，只有一个元素时。我们可以分析一下全排列的过程：
 首先，我们固定第一个字符a，求后面两个字符bc的排列
 当两个字符bc排列求好之后，我们把第一个字符a和后面的b交换，得到bac，接着我们固定第一个字符b，求后面两个字符ac的排列
 现在是把c放在第一个位置的时候了，但是记住前面我们已经把原先的第一个字符a和后面的b做了交换，为了保证这次c仍是和原先处在第一个位置的a交换，我们在拿c和第一个字符交换之前，先要把b和a交换回来。在交换b和a之后，再拿c和处于第一位置的a进行交换，得到cba。我们再次固定第一个字符c，求后面两个字符b、a的排列
 既然我们已经知道怎么求三个字符的排列，那么固定第一个字符之后求后面两个字符的排列，就是典型的递归思路了
 * Created by yan on 2016/4/10.
 */
public class Permutation {
    public static void permutation(char[]ss,int i){
        if(ss==null||i<0 ||i>ss.length){
            return;
        }
        if(i==ss.length){
            System.out.println(new String(ss));
        }else{
            for(int j=i;j<ss.length;j++){
                char temp=ss[j];//交换前缀,使之产生下一个前缀
                ss[j]=ss[i];
                ss[i]=temp;
                permutation(ss,i+1);
                temp=ss[j]; //将前缀换回来,继续做上一个的前缀排列.
                ss[j]=ss[i];
                ss[i]=temp;
            }
        }
    }

    static void swap(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    // http://www.07net01.com/2015/08/902510.html
    static void permutation(char[] arr, int index, int size) {
        if (index == size) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = index; i < size; i++) {
                if(i != index && arr[i] == arr[index])
                    continue;
                swap(arr, i, index);
                permutation(arr, index+1, size);
                swap(arr, i, index);
            }
        }
    }

    public static void main(String args[]){
        char []ss={'a','b','c'};
//        permutation(ss,0);
        // or
        permutation(ss,0,3);

    }
}
