package AHNU.learning.data_structure;

/*
    给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。

    示例 1：
    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
*/

import java.util.List;

public class Question_0023 {

    public static void main(String[] args) {
        Question_0023 q = new Question_0023();
        ListNode[] lists = new ListNode[3];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = Util.createNewListNode();
        }
        Util.printListNode(q.mergeKLists(lists));
    }

    // 递归分治法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return mergelist(lists, 0, lists.length - 1);
    }

    public ListNode mergelist(ListNode[] lists, int start, int end) {
        if (end == start){
            return lists[start];
        }
        if (end - start == 1) {
            return mergeTwoLists(lists[start], lists[end]);
        } else {
            return mergeTwoLists(mergelist(lists, start, start + (end - start) / 2), mergelist(lists, start + (end - start) / 2 + 1, end));
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode head, index;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        index = head;
        while (true) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    index.next = l2;
                    l2 = l2.next;
                    index = index.next;
                } else {
                    index.next = l1;
                    l1 = l1.next;
                    index = index.next;
                }
            } else if (l1 == null) {
                index.next = l2;
                return head;
            } else if (l2 == null) {
                index.next = l1;
                return head;
            }
        }
    }

}
