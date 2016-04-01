package off.subject12;

/**
 * 这个有点难！！！
 * Created by yan on 2016/4/1.
 */
public class PrintMaxOfNDigits {
    //第二中方法实现，全排序实现
    public void PrintMaxOfNdigits(int[] number,int length,int index){
        if(index ==length-1){
            PrintNumber(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[index+1]=i;
            PrintMaxOfNdigits(number, length, index+1);
        }
    }

    public void PrintNumber(int[] number){   //该方法是负责打印一个正类，千万不要尝试将数组变成一个整数
        boolean isBeginning=true;
        for(int i=0;i<number.length;i++){
            if(isBeginning&&number[i]!=0)
                isBeginning=false;
            if(!isBeginning){
                System.out.print(number[i]);
            }
        }
    }

    public void Test1(int n){
        if(n<=0)
            return;
        int[] number = new int[n];
        for(int i=0;i<10;i++){
            number[0]=i;
            PrintMaxOfNdigits(number, n, 0);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new PrintMaxOfNDigits().Test1(2);
    }
}
