package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums 和一个整数 target 。
    向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

    示例 1：
        输入：nums = [1,1,1,1,1], target = 3
        输出：5
        解释：一共有 5 种方法让最终目标和为 3 。
        -1 + 1 + 1 + 1 + 1 = 3
        +1 - 1 + 1 + 1 + 1 = 3
        +1 + 1 - 1 + 1 + 1 = 3
        +1 + 1 + 1 - 1 + 1 = 3
        +1 + 1 + 1 + 1 - 1 = 3
    示例 2：
        输入：nums = [1], target = 1
        输出：1

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/target-sum
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question_0494 {

    public static void main(String[] args) {
        Question_0494 q = new Question_0494();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(q.findTargetSumWaysArray(nums, 3));
    }

    // 使用动态规划的思想  hashmap其实消耗了更多的内存和更低的执行效率 还是应该使用数组的
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,Integer>[] maps = new HashMap[nums.length + 1];
        maps[0] = new HashMap<Integer,Integer>();
        maps[0].put(0,1);
        for (int i = 1; i < nums.length + 1; i++) {
            maps[i] = new HashMap<Integer, Integer>();
            for (Integer key : maps[i-1].keySet()) {
                maps[i].put(key + nums[i-1], maps[i].getOrDefault(key + nums[i-1],0) + maps[i-1].get(key));
                maps[i].put(key - nums[i-1], maps[i].getOrDefault(key - nums[i-1],0) + maps[i-1].get(key));
            }
        }
        return maps[nums.length].getOrDefault(target, 0);
    }

    // 更优解 找出要取-号的数字 直接转换为0-1背包问题
    public int findTargetSumWaysArray(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum+=i;
        }
        if ((target + sum) % 2 == 1) return 0;
        int res = (sum+target)/2;
        if(res<0) res = -res;
        int[] dp = new int[res+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = res; j >=nums[i] ; j--) {
                dp[j] +=dp[j-nums[i]];
            }
        }
        return dp[res];
    }
}



