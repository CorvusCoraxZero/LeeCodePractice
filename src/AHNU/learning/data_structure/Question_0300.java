package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

    示例 1：
        输入：nums = [10,9,2,5,3,7,101,18]
        输出：4
        解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    示例 2：
        输入：nums = [0,1,0,3,2,3]
        输出：4

    进阶：
        你可以设计时间复杂度为 O(n2) 的解决方案吗？
        你能将算法的时间复杂度降低到 O(n log(n)) 吗?

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
    */

public class Question_0300 {

    public static void main(String[] args) {
        Question_0300 q = new Question_0300();
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(q.lengthOfLIS(nums));

    }

    // 动态规划解题 时间复杂度O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int round=0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j] > round){
                        round = dp[j];
                    }
                }
            }
            dp[i] = round+1;
            if (max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

}