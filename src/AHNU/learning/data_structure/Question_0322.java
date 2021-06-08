package AHNU.learning.data_structure;

/*
    给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

    你可以认为每种硬币的数量是无限的。

     

    示例 1：

    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/coin-change
*/

import java.util.Arrays;
import java.util.Comparator;

public class Question_0322 {

    public static void main(String[] args) {
        Question_0322 q = new Question_0322();
        int[] nums = new int[]{431,62,88,428};
        System.out.println(q.coinChange(nums,9084));
    }

    // 动态规划解题
    public int coinChange(int[] coins, int amount) {
        int[] dq = new int[amount+1];
        for (int i = 1; i < dq.length; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i || dq[i-coins[j]] == -1) continue;
                if (minStep > (dq[i-coins[j]]+1)) minStep = dq[i-coins[j]]+1;
            }
            if (minStep != Integer.MAX_VALUE){
                dq[i] = minStep;
            }else dq[i] = -1;
        }
        return dq[amount];
    }
}