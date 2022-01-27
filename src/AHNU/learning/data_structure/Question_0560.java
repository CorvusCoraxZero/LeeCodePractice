package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums 和一个整数k ，请你统计并返回该数组中和为k的连续子数组的个数。

    示例 1：
        输入：nums = [1,1,1], k = 2
        输出：2
    示例 2：
        输入：nums = [1,2,3], k = 3
        输出：2

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
*/

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question_0560 {

    public static void main(String[] args) {
        Question_0560 q = new Question_0560();
        int[] nums = new int[]{1, 2, -2, 3};
        System.out.println(q.subarraySum(nums, 3));
    }

    // 前缀和+hash

    /**
     * 我们定义 pre[i]pre[i] 为 [0..i][0..i] 里所有数的和，则 pre[i]pre[i] 可以由 pre[i-1]pre[i−1] 递推而来，即：
     * pre[i]=pre[i-1]+nums[i]
     * 那么「[j..i][j..i] 这个子数组和为 kk 」这个条件我们可以转化为
     * pre[i]-pre[j-1]==k
     * 简单移项可得符合条件的下标 jj 需要满足
     * pre[j-1] == pre[i] - k
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> pre = new HashMap<>();
        pre.put(0,1); // 初始化

        int count = 0; // 记录次数
        int sum = 0; // 累加记录数值
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (pre.containsKey(sum - k)) {
                count += pre.get(sum - k);
            }
            pre.put(sum, pre.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // TMD仔细一想还不如直接枚举
    //（❌ 解法正确 但超出内存限制） 使用动态规划的解法 因为涉及复数所以j的坐标要校准0点
    public int subarraySumDP(int[] nums, int k) {
        int content = 0; // dp 可能到大的最大数
        int negative = 0; // dp可能到达的最小数的绝对值
        for (int num : nums) {
            content += num > 0 ? num : num * -1;
            negative += num > 0 ? 0 : num * -1;
        }

        // 排除两个无解情况 防止坐标越界
        if (content - negative < k) {
            return 0;
        } else if (negative * -1 > k) {
            return 0;
        }

        content = content + 1;
        int[][] dp = new int[nums.length + 1][content];
        for (int i = 0; i < nums.length + 1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < content; j++) {
                if (j - nums[i - 1] >= 0 && j - nums[i - 1] < content) {
                    if (dp[i - 1][j - nums[i - 1]] > 0) {
                        dp[i][j] = dp[i - 1][j - nums[i - 1]];
                    }
                }
                if (nums[i - 1] == j - negative) {
                    if (dp[i][j] <= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] += 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            if (dp[i][k + negative] > 0) {
                result += dp[i][k + negative];
            }
        }
        return result;
    }

}



