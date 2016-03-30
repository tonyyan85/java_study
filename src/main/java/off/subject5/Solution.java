package off.subject5;

import java.util.ArrayList;

/**
 * 最佳代码：代码思路借助栈，遍历的时候入栈，
 * 由于数据结构中栈的特点是先进后出，所以遍历的过程中压栈，推栈，
 * 完了弹栈加到ArrayList中。有两个容易出错的地方：
 * 第一，第一次测试用例，{}返回[ ],null是null，而[ ]是new ArrayList（）但是没有数据。
 * 第二，遍历stack用的方法是！stak.isEmpty()方法，而不是for循环size遍历。
 *
 * --*** 递归超简洁版本 ***--
 * 递归本质上也是一个栈，经典的后进先出。
 * Created by yan on 2016/3/30.
 */
public class Solution {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String args[]){
        ListNode listNode1  = new ListNode(1);
        ListNode listNode2  = new ListNode(2);
        ListNode listNode3  = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ArrayList<Integer> list = new Solution().printListFromTailToHead(listNode1);
        for(Integer in : list){
            System.out.println(in);
        }

    }
}
