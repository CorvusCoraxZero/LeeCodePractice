package AHNU.learning.data_structure;

/*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/unique-paths
*/

public class Question_0062 {

    public static void main(String[] args) {
        Question_0062 q = new Question_0062();

        System.out.println(q.uniquePaths2(1, 1));
    }

    /*尝试使用最朴素自然的想法 运用递归 让机器人优先向右走然后再向下走 到达终点就路径加1
    哈哈哈哈哈 超时了......*/
    public int uniquePaths(int m, int n) {
        return recursionGo(m, n, 1, 1);
    }

    /**
     * 递归函数
     *
     * @param m             纵轴长度
     * @param n             横轴长度
     * @param indexm,indexn 当前坐标
     * @return
     */
    public int recursionGo(int m, int n, int indexm, int indexn) {
        if (indexm == m || indexn == n) { // 当走到右边款或者下边框的时候就没有别的选择了 只剩一条路了 直接返回就好了
            return 1;
        }
        return recursionGo(m, n, indexm, indexn + 1) + recursionGo(m, n, indexm + 1, indexn);
    }

    /*运用动态规划的思想 填表记录当前位置有几种路线可以到 动态规划转移方程 f(i,j)=f(i−1,j)+f(i,j−1) */
    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) { // 初始化数组 上沿和右沿都设为1
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) { // 初始化数组 上沿和右沿都设为1
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
