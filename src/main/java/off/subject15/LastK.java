package off.subject15;

/**
 * 题目：
 * 输入一个单向链表，输出该链表中倒数第k个结点。链表的倒数第0个结点为链表的尾指针。
 *
 * 结题思路：
 * 1)将pSlow和pFast同时指向链表的头部
 * 2）将快指针向后移动K位
 * 3）快慢指针同时移动，当pFast为空时，pSlow就指向倒数第K个节点
  * Created by yan on 2016/4/10.
 */

class ListNode{
    int key;
    ListNode next;
    public ListNode(int key){
        this.key=key;
    }
}


public class LastK {
    public ListNode getLastK(ListNode head,int k){
        if(k<0) {
            System.err.println("k<0");
            return null;
        }
        ListNode p=head;
        ListNode pk=head;
        for(;k>0;k--){//pk走了k步
            if(pk.next!=null)
                pk=pk.next;
            else {
                return null;
            }
        }
        while(pk.next!=null){//pk再走n-k步，p也走n-k,则p为倒数第k个结点
            p=p.next;
            pk=pk.next;
        }
        return p;
    }
    public static void main(String[] args) {
        int k=2;
        ListNode head=new ListNode(0);
        ListNode[] p=new ListNode[6];
        for (int i = 0; i < p.length; i++) {
            p[i]=new ListNode(i+1);
            if(i>0)
                p[i-1].next=p[i];
            else {
                head.next=p[0];
            }
        }
        LastK l=new LastK();

        ListNode r=l.getLastK(head, k);
        System.out.println(r.key);
    }
}
