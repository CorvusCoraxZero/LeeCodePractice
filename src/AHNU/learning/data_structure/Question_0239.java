package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    返回滑动窗口中的最大值。

    示例 1：
        输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
        解释：
        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sliding-window-maximum
*/

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Question_0239 {

    public static void main(String[] args) {
        Question_0239 q = new Question_0239();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        for (int i : q.maxSlidingWindow2(nums, 3)) {
            System.out.print(i + " ");
        }
    }

    // 最自然的想法 维护一个优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 1) return nums;
        if (k == 0) return null;
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[0] == p2[0] ? p2[1] - p1[1] : p2[0] - p1[0]);
        for (int i = 0; i < k; i++) { // 将前k个数初始化到优先队列中
            pq.offer(new int[]{nums[i], i});
        }
        result[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) { //如果堆头元素不在窗口中则将其弹出
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }

    // 单调队列的解法
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 1) return nums;
        if (k == 0) return null;
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {       // 初始化滑动窗口内的单调队列 存储下标
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        result[0] = nums[queue.getFirst()];

        for (int i = k; i < nums.length; i++) {       // 初始化滑动窗口内的单调队列
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.pollLast();
            }
            queue.addLast(i);
            while (queue.getFirst() <= i - k) {
                queue.peekFirst();
            }
            result[i - k + 1] = nums[queue.getFirst()];
        }
        return result;
    }
}