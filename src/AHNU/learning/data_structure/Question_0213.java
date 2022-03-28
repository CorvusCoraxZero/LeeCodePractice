package AHNU.learning.data_structure;

/*
    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
    这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
    给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
    
    示例1：
        输入：nums = [2,3,2]
        输出：3
        解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

    示例 2：
        输入：nums = [1,2,3,1]
        输出：4
        解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
            偷窃到的最高金额 = 1 + 3 = 4 。

    示例 3：
        输入：nums = [1,2,3]
        输出：3
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/house-robber-ii
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Question_0213 {

    public static void main(String[] args) {
        Question_0213 q = new Question_0213();
        int[] ints = {1,3,1,3,100};
        System.out.println(q.rob(ints));
    }

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        // 因为首位相连
        // 所以第一个和最后一个只能选择一个
        // 直接分成两种情况讨论
        // 将第一个房子或者最后一个房子直接删除出列表
        // 将环形断开
        return Math.max(robHouse(nums,1,nums.length-1),robHouse(nums,0,nums.length-2));
    }

    public int robHouse(int[] nums, int head, int tail) {
        int[] dp = new int[nums.length];
        dp[head] = nums[head];
        dp[head+1] = Math.max(nums[head],nums[head+1]);
        for (int i = head+2; i <= tail; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[tail];
    }

}



