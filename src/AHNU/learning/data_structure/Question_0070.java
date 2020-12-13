package AHNU.learning.data_structure;

/*
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。

    示例 1：
    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    输出：7
    解释：因为路径 1→3→1→1→1 的总和最小。

    加强版：（字节跳动面试题）
        加上一个限制条件：每次你可以爬 1 或 2 个台阶。但是不能连续跳两步（我的理解就是这次跳了两个台阶，下次就不能跳两个台阶了）。。
        （解题思路 依然使用动态规划 但是记录每一层解法的数据分为两个部分 一个是走到这一层的解法 一个是跳到这一层的解法 当前楼梯的解法 = 前一个楼梯的所有解法 + 前两个楼梯走上来的解法）

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/minimum-path-sum
*/

public class Question_0070 {

    public static void main(String[] args) {
        Question_0070 q = new Question_0070();

        System.out.println(q.climbStairs(4));
        System.out.println(q.climbStairsPro(4));
    }

    //动态规划
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //字节跳动
    public int climbStairsPro(int n) {
        int[][] dp = new int[n + 1][2]; //[i][0] 表示从i-1层走到第i层的解法的数量 [i][1] 表示从i-2层跳到第i层的解法的数量
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 2][0];
        }
        return dp[n][1] + dp[n][0];
    }
}
