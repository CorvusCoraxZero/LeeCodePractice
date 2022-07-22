package AHNU.learning.data_structure;

/*
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/add-two-numbers
*/

import AHNU.learning.data_structure.entity.ListNode;

import java.util.Scanner;

public class Question_0002 {

    public final int aa = 123;
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode index;

        Scanner sc = new Scanner(System.in);

        int flag = 0;
        index = l1;
        ListNode pre = index;
        while (flag != -1){
            if ((flag = sc.nextInt()) == -1) {
                pre.next = null;
                break;
            }
            index.val = flag;
            index.next = new ListNode(0);
            pre = index;
            index = index.next;
        }
        flag = 0;
        index = l2;
        pre = index;
        while (flag != -1){
            if ((flag = sc.nextInt()) == -1) {
                pre.next = null;
                break;
            }
            index.val = flag;
            index.next = new ListNode(0);
            pre = index;
            index = index.next;
        }

        Question_0002 q2 = new Question_0002();
        ListNode result = q2.addTwoNumbers(l1,l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
        ThreadLocal local = new ThreadLocal();
        local.set("String");

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode index = result;
        ListNode pre = index;
        boolean flag1=true,flag2=true;
        int a = 0,b = 0;
        int carry = 0;
        while (flag1 || flag2){
            if (l1.next == null) flag1 = false; // 判断是否进入下一次循环
            if (l2.next == null) flag2 = false;

            a = l1.val;
            b = l2.val;
            index.val = (a + b + carry) % 10;  // 对新链表的节点进行赋值
            if (a + b + carry >= 10){
                carry = 1;
            }else carry = 0;
            index.next = new ListNode();
            pre = index;
            index = index.next;

            if (flag1){             // 进入下一个节点
                l1 = l1.next;
            }else l1.val = 0;
            if (flag2){
                l2 = l2.next;
            }else l2.val = 0;

        }
        if (carry == 1){
            index.val = 1;
        }else pre.next = null;
        return result;
    }
}