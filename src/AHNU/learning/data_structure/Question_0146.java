package AHNU.learning.data_structure;

/*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
    说明：不允许修改给定的链表。

    进阶：
        你是否可以使用 O(1) 空间解决此题？

    示例 1：
        输入：head = [3,2,0,-4], pos = 1
        输出：返回索引为 1 的链表节点
        解释：链表中有一个环，其尾部连接到第二个节点

*/

public class Question_0146 {

    public static void main(String[] args) {
        Question_0146 q = new Question_0146();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,null)))));
        ListNode star = head.next.next;
        head.next.next.next.next.next = star;
        System.out.println(q.detectCycle(head).val);
    }

    // 采用昨天快慢指针的思路 快指针是慢指针速度的两倍 所以快指针会在慢指针入环后第一圈的某个位置与快指针相遇
    // 设头节点到入环点的位置为a 入环点到快慢指针相遇点的长度为b 剩余环长为c 即环的长度为b+c 设快指针已在环上绕了 n 圈
    // 又快指针是慢指针速度的两倍  即 a+n(b+c)+b = 2(a+b) -------> a = (n-1)(b+c)+c 即当他们相遇后 从a出发一个快指针会在原始快指针走完剩下的圈长后
    // 经过(n-1)个整圈 与 后出发的指针在环的入口相遇
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.next != null) {
                /* 虽然这里快指针往前直接走了两步 看似跳了一格 慢指针可能会碰不上 但实际一定会碰上
                    因为慢指针在中间那一格的情况 只可能是快慢指针重合时的情况
                    所以做 快慢指针的题 的时候 一定要等快慢指针都走完一轮之后再进行判断 */
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

