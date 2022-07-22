package AHNU.learning.data_structure;

/*
    编写一个程序，找到两个单链表相交的起始节点。

    如下面的两个链表：
    输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    输出：Reference of the node with value = 8
    输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

    程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
*/

import AHNU.learning.data_structure.entity.ListNode;

public class Question_0160 {

    public static void main(String[] args) {
        Question_0160 q = new Question_0160();
        ListNode a = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode b = new ListNode(5,new ListNode(6,a.next));
        System.out.println(q.getIntersectionNode(a,b).val);
    }

    // 最容易想到的是 hash的方法 可以满足o(n)的时间复杂度 但是题目要求o(1)的空间复杂度 所以不得的不再想别的方法
    // 使用双指针的方法 两指针同时从头节点出发 到链表结尾时 跳转到另一个链表的头节点 继续往后走
    // 因为两个指针走的路程的总长度时相同的 所以最后必会重合在两个链表的重合部分 两个指针相遇的点就是链表重合的起点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2 = headB;
        int count = 2;

        while (true){
            if (p1 == p2){
                return p1;
            }
            if (p1.next != null){
                p1 = p1.next;
            }else {
                if (count >= 0){
                    count--;
                    p1 = headB;
                }else return null;
            }
            if (p2.next != null){
                p2 = p2.next;
            }else {
                if (count >= 0){
                    p2 = headA;
                    count--;
                }else return null;
            }
        }
    }
}

