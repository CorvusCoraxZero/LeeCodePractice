package AHNU.learning.data_structure;

/*
   给你一个整数数组 nums ，你需要找出一个连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
   请你找出符合题意的 最短子数组，并输出它的长度。

    示例 1：
        输入：nums = [2,6,4,8,10,9,15]
        输出：5
        解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
    示例 2：
        输入：nums = [1,2,3,4]
        输出：0
    示例 3：
        输入：nums = [1]
        输出：0

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question_0581 {

    public static void main(String[] args) {
        Question_0581 q = new Question_0581();
        int[] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(q.findUnsortedSubarray(nums));
    }

    // 使用类似滑动窗口的方法
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int head = -1, tail = -1; // 子数组的起始和结束坐标
        int max = nums[0], min = nums[0]; // 子数组中最大的数和最小的数
        for (int i = 1; i < nums.length; i++) {
            if (head < 0) {
                if (nums[i] < nums[i - 1]) {
                    head = i - 1;
                    tail = i;
                    max = nums[i - 1];
                    min = nums[i];
                } else {
                    continue;
                }
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            // 如果当前数比最大值值小 就将当前tail坐标移动到当前坐标
            if (nums[i] < max) {
                tail = i;
            }
            // 如果当前的数比最小数还小 或者等于最小值 head就往前寻找 直到比当前数更小
            if (nums[i] <= min) {
                min = nums[i];
                while (head > 0) {
                    if (nums[i] < nums[head-1]) {
                        head--;
                    } else {
                        break;
                    }
                }
            }
        }
//            System.out.println(head + "        " + tail);
        return head==tail ? 0 : tail - head + 1;
    }
}



