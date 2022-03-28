package AHNU.learning.data_structure;

/*
    给你一个非负整数数组nums ，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    假设你总是可以到达数组的最后一个位置。

    示例 1:
        输入: nums = [2,3,1,1,4]
        输出: 2
        解释: 跳到最后一个位置的最小跳跃数是 2。
            从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。

    示例 2:
        输入: nums = [2,3,0,1,4]
        输出: 2

    提示:
        1 <= nums.length <= 104
        0 <= nums[i] <= 1000

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/jump-game-ii
*/

import java.util.Arrays;

public class Question_0045 {

    public static void main(String[] args) {
        Question_0045 q = new Question_0045();

        int[] nums = {2,3,1,1,4};
        System.out.println(q.jump(nums));
    }

    // dp[i] 表示到当前位置需要的最少步数
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i+1; j < Math.min(i+nums[i]+1,nums.length); j++) {
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
        }
        return dp[nums.length-1];
    }
}
