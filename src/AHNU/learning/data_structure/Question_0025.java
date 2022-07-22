package AHNU.learning.data_structure;

/*
    25. K 个一组翻转链表
    给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

    示例 1：
        输入：head = [1,2,3,4,5], k = 2
        输出：[2,1,4,3,5]

    示例 2：
        输入：head = [1,2,3,4,5], k = 3
        输出：[3,2,1,4,5]

    提示：
        链表中的节点数目为 n
        1 <= k <= n <= 5000
        0 <= Node.val <= 1000
    
    进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
    
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

import AHNU.learning.data_structure.entity.ListNode;
import AHNU.learning.data_structure.entity.Util;

import java.util.Optional;

public class Question_0025 {

    public static void main(String[] args) {
        Question_0025 q = new Question_0025();
        ListNode lists = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9)))))))));
        int input = 4;
        Util.printListNode(q.reverseKGroup(lists, input));
    }

    /**
     * 四个指针的方式 一次遍历完成转换
     * 以k个节点为一个单元  单元头指针 下一单元头指针 单元内前后指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        // 数据初始化
        ListNode urear = head;
        for (int i = 1; i < k; i++) {
            if (urear.next != null) {
                urear = urear.next;
            } else {
                return head;
            }
        }
        ListNode result = urear;
        ListNode nextRear;
        ListNode pre = head;
        ListNode post = pre;
        ListNode tmp;
        // 记录结束的标志
        boolean flag = true;
        while (flag) {
            // 获取到下一单元的尾巴
            nextRear = urear;
            for (int i = 0; i < k; i++) {
                if (nextRear.next != null) {
                    nextRear = nextRear.next;
                } else {
                    nextRear = urear.next;
                    flag = false;
                    break;
                }
            }
            // 单元内转换 + 单元间衔接(当前单元的头指向下一单元的尾)
            pre = post;
            post = pre.next;
            pre.next = nextRear;
            for (int i = 0; i < k - 1; i++) {
                tmp = post.next;
                post.next = pre;
                pre = post;
                post = tmp;
            }
            urear = nextRear;
        }
        return result;
    }


}
