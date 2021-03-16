package AHNU.learning.data_structure;

/*
    反转一个单链表。

    示例:
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL

    进阶:
        你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-linked-list
*/

public class Question_0206 {

    public static void main(String[] args) {
        Question_0206 q = new Question_0206();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode x = q.reverseListRC(null);
        while (x != null){
            System.out.println(x.val);
            x = x.next;
        }
    }

    // 迭代的反转 想法就是head不断的吧接下来的元素甩到它身后的尾巴上去
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = head.next,q = head,temp;
        while (p != null)
        {
            q.next = p.next;    // 前后交换
            p.next = dummyHead.next;
            dummyHead.next = p;
            p = q.next;
        }
        return dummyHead.next;
    }

    // 递归的反转  想法是将头元素插入已经反转好的链表的尾部
    public ListNode reverseListRC(ListNode head) {
        if (head == null || head.next == null ){
            return head;
        }
        ListNode rh = reverseList(head.next);
        head.next.next = head;  // head.next 实际是的一反转部分链表的尾部
        head.next = null;
        return rh;
    }
}

