package AHNU.learning.data_structure;

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Question_0021 {

    public static void main(String[] args) {
        Question_0021 q = new Question_0021();
        Scanner sc = new Scanner(System.in);
        int temp;
        ListNode headf = new ListNode();
        ListNode heads = new ListNode();
        ListNode indexf = headf,indexs = heads,pro = headf;

        while (true){
            temp = sc.nextInt();
            if (temp != -1)
            {
                indexf.val = temp;
                indexf.next = new ListNode();
                pro = indexf;
                indexf = indexf.next;
            }else {
                pro.next = null;
                break;
            }
        }
        pro = heads;
        while (true){
            temp = sc.nextInt();
            if (temp != -1)
            {
                indexs.val = temp;
                indexs.next = new ListNode();
                pro = indexs;
                indexs = indexs.next;
            }else {
                pro.next = null;
                break;
            }
        }
        ListNode index = q.mergeTwoLists(headf,heads);
        while (true){
            System.out.println(index.val);
            if (index.next == null) break;
            index = index.next;
        }
    }

    //  常规的合并链表操作改进 不使用新的链表 一个为空直接移动指针
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode head,index;
        if (l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        }else{
            head = l1;
            l1 = l1.next;
        }
        index = head;
        while (true){
            if (l1 != null && l2 != null){
                if (l1.val > l2.val){
                    index.next = l2;
                    l2 = l2.next;
                    index = index.next;
                }else {
                    index.next = l1;
                    l1 = l1.next;
                    index = index.next;
                }
            }
           else if (l1 == null){
                index.next = l2;
                return head;
            }else if (l2 == null){
                index.next = l1;
                return head;
            }
        }
    }

    // 递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }

}
