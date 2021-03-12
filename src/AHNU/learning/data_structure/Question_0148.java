package AHNU.learning.data_structure;

/*
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    进阶：
        你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
*/

public class Question_0148 {

    public static void main(String[] args) {
        Question_0148 q = new Question_0148();
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(5, new ListNode(4, new ListNode(3,null)))));
        head = q.sortList(null);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    /*
    * 解法一：归并排序 递归解法
    * 使用快慢指针得到链表的中点 （快指针到头的时候 慢指针正好在中点）
    * 从链表的中点拆分子链 直到子链的大小小于等于1
    * 合并有序的子链
    * */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null ){ // 如果链表中小于一个节点 直接返回
            return head;
        }

        // 先对链表进行拆分
        ListNode fast = head,slow = head;
        while (true){
            if (fast.next != null){
                fast = fast.next.next;
            }else break;
            if (fast == null){
                break;
            }
            slow = slow.next;
        }
        // 断链
        fast = slow.next;
        slow.next = null;
        // 合并
        return merge(sortList(head),sortList(fast));
    }

    private ListNode merge(ListNode head1,ListNode head2){  // 合并有序链表的操作;
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null){
            if (temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next =temp2;
                temp2 = temp2.next;
            }
            temp =temp.next;
        }
        if (temp1 != null){
            temp.next = temp1;
        }else if (temp2 != null){
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}

