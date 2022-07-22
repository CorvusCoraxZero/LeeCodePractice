package AHNU.learning.data_structure;

/*
    给定一个链表，判断链表中是否有环。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    如果链表中存在环，则返回 true 。 否则，返回 false 。
    进阶：
    你能用 O(1)（即，常量）内存解决此问题吗？

    示例 1：
    输入：head = [3,2,0,-4], pos = 1
    输出：true
    解释：链表中有一个环，其尾部连接到第二个节点。

*/

import AHNU.learning.data_structure.entity.ListNode;

import java.util.*;

public class Question_0141 {

    public static void main(String[] args) {
        Question_0141 q = new Question_0141();
        ListNode head = new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null)))));
        ListNode star =head.next.next;
        head.next.next.next.next.next = star;
        System.out.println(q.hasCycle(head));
    }

    // 最简单的方法就是在节点上标记 改变访问过的节点的值  但是这样应该有违题目的意思
    public boolean hasCycle2(ListNode head) {
        while (head != null)
            if (head.val != Integer.MIN_VALUE+777){
                head.val = Integer.MIN_VALUE+777;
                head = head.next;
            }else if (head.val == Integer.MIN_VALUE+777){
                return true;
            }
        return false;
    }

    // 使用快慢指针解题 不改变节点数值 且额外空间为o(1) 慢指针一次跑一格  快指针指针一次跑两格 当他们相遇则说明有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) return true;  // 如果快慢指针相遇 说明有环
        }
        return false;
    }
}

