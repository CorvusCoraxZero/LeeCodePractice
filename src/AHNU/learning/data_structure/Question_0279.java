package AHNU.learning.data_structure;

/*
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
    完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

    示例 1：
        输入：n = 12
        输出：3
        解释：12 = 4 + 4 + 4
    示例 2：
        输入：n = 13
        输出：2
        解释：13 = 4 + 9

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/perfect-squares
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Question_0279 {

    public static void main(String[] args) {
        Question_0279 q = new Question_0279();
        System.out.println(q.numSquares(12));
    }


    // dp动态规划解题 dp[i] = min(dp[i-k]+1) k为从1~n的完全平方数
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        ArrayList<Integer> pow = new ArrayList<>();
        for (int i = 1; ; i++) {
            int x = (int) Math.pow(i,2);
            if (x > n) break;
            else if (x == n)  return 1;
            pow.add(x);
        }
        for (int i = 1; i <= n; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = 0; j < pow.size(); j++) {
                int k = pow.get(j);
                if (k == i){
                    minStep = 1;
                    break;
                }else if (k > i){
                    break;
                }else {
                    if (minStep > dp[i-k] + 1){
                        minStep = dp[i-k] + 1;
                    }
                }
            }
            dp[i] = minStep;
        }
        return dp[n];
    }

}