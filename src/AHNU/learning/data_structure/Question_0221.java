package AHNU.learning.data_structure;

/*
    在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

    输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    输出：4

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximal-square

*/

public class Question_0221 {

    public static void main(String[] args) {
        Question_0221 q = new Question_0221();
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix2 = new char[][]{{'0', '1'}};

        System.out.println(q.maximalSquare(matrix2));
    }

    // 动态规划解题
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0; // 记录dp中最大的值
        for (int i = 0; i < matrix.length; i++) { // 初始化dp
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) { // 初始化dp
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                }
            }
        }
        return max*max;
    }
}
