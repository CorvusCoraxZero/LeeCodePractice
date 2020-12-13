package AHNU.learning.data_structure;

/*
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。

    示例 1：
    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    输出：7
    解释：因为路径 1→3→1→1→1 的总和最小。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/minimum-path-sum
*/

public class Question_0064 {

    public static void main(String[] args) {
        Question_0064 q = new Question_0064();

        int[][] road = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(q.minPathSum(road));
    }

    /*典型的动态规划问题*/
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < grid[0].length + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;dp[1][0] = 0;
        for (int i = 1; i < grid.length + 1; i++) {
            for (int j = 1; j < grid[0].length + 1; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
