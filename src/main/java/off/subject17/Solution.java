package off.subject17;

/**
 * 原题：
 * 合并两个排好序的单链表
 * 解题思路：
 * 使用头结点root进行辅助操作，创建一个头结点，再使用两个引用指向两个链表的头结点，
 * 将较小的结点值的结点摘下来接到root链表的末尾，同时被摘的链头引用移动到下一个结点，
 * 一直操作，到到原先两个链表中有一个为空，最后再将剩下的结点接到root链表的末尾。
 * 最后返回root的下一个结点，其就为新的链表头。
 * Created by yan on 2016/4/10.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // 创建一个头结点，最后还要删除掉
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next; // 移动到新的尾结点
        }
        tail.next = (l1 != null ? l1 : l2);
        return head.next; // head的下一个节点是第一个数据结点
    }
}
