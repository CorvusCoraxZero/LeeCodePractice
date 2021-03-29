package AHNU.learning.data_structure;

/*
  请判断一个链表是否为回文链表。

    示例 1:
        输入: 1->2
        输出: false
    示例 2:
        输入: 1->2->2->1
        输出: true

    进阶：
        你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/palindrome-linked-list
*/

public class Question_0234 {

    public static void main(String[] args) {
        Question_0234 q = new Question_0234();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(7, new ListNode(2, new ListNode(3,null)))));
        System.out.println(q.isPalindrome(head));
    }

    /*
     * 运用快慢指针找到中点 然后反转后面部分的链表
     * 暂时不考虑链表的修复
     * */
    public boolean isPalindrome(ListNode head) {
        ListNode midpoint = findMidpoint(head);
        ListNode reverseHead = reverseList(midpoint);
        while (reverseHead != midpoint) { // 无论奇数还是偶数 反转的链表 走到了midpoint 就说明这是回文的串；
            if (reverseHead.val == head.val) {
                reverseHead = reverseHead.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
     * 查找链表的中间点 如果链表数量为偶数则会返回中间右的值 如果为基数则会返回中间点
     * */
    private ListNode findMidpoint(ListNode head) {
        ListNode fast = new ListNode(0,head), slow = new ListNode(0,head) ;
        while (true) {
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        return slow;
    }

    /*
     * 反转链表 反转head之后的链表 返回反转后链表的头部
     * */
    private ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = head.next, temp;
        head.next = null;
        while (pre != null) {
            temp = pre.next;
            pre.next = head;
            head = pre;
            pre = temp;
        }
        return head;
    }
}
