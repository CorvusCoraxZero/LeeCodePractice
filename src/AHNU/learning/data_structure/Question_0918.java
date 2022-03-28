package AHNU.learning.data_structure;

/*
    给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
    环形数组意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
    子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，不存在i <= k1, k2 <= j其中k1 % n == k2 % n。

    示例 1：
        输入：nums = [1,-2,3,-2]
        输出：3
        解释：从子数组 [3] 得到最大和 3

    示例 2：
        输入：nums = [5,-3,5]
        输出：10
        解释：从子数组 [5,5] 得到最大和 5 + 5 = 10

    示例 3：
        输入：nums = [3,-2,2,-3]
        输出：3
        解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3


    提示：
        n == nums.length
        1 <= n <= 3 * 104
        -3 * 10^4<= nums[i] <= 3 * 10^4

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Question_0918 {

    public static void main(String[] args) {
        Question_0918 q = new Question_0918();
        int[] ints = {2,-5,2};
        System.out.println(q.maxSubarraySumCircular2(ints));
    }

    // 方法一： 找到不循环队列最大的连续和  与 队列总和 - 不循环队列最小的连续和（如果小于0）
    public int maxSubarraySumCircular(int[] nums) {
        // 最大连续和
        int sum = nums[0];
        int positive = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(current, 0) + nums[i];
            positive = Math.max(current, positive);
            sum += nums[i];
        }

        // 最小连续和
        int negative = nums[0];
        current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.min(current, 0) + nums[i];
            negative = Math.min(current, negative);
        }

        int result = Math.max(positive, sum - negative);
        return result > 0 ? result : positive;
    }

    // 方法二： 分两种勤快 不成环  成环：从头开始找到最大的连续 从尾找到最大连续
    public int maxSubarraySumCircular2(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

            // 不成环
        int positive = nums[0];
        int current = nums[0];;
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(current, 0) + nums[i];
            positive = Math.max(current, positive);
        }

        // 成环
        // 右边
        int right = nums[nums.length - 1];
        int[] rightmax = new int[nums.length];
        rightmax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right = right + nums[i];
            rightmax[i] = Math.max(right, rightmax[i + 1]);
        }
        // 左边
        int left = nums[0];
        int result = nums[0] + rightmax[2];
        for (int i = 1; i < nums.length - 2; i++) {
            left = left + nums[i];
            result = Math.max(left + rightmax[i + 2], result);

        }
        return Math.max(positive, result);
    }

}



