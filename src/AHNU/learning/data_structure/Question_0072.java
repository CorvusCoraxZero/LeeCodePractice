package AHNU.learning.data_structure;

/*
    给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
    你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符

    示例 1：
        输入：word1 = "horse", word2 = "ros"
        输出：3
        解释：
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')

    示例 2：
        输入：word1 = "intention", word2 = "execution"
        输出：5
        解释：
        intention -> inention (删除 't')
        inention -> enention (将 'i' 替换为 'e')
        enention -> exention (将 'n' 替换为 'x')
        exention -> exection (将 'n' 替换为 'c')
        exection -> execution (插入 'u')

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/edit-distance
*/

public class Question_0072 {

    public static void main(String[] args) {
        Question_0072 q = new Question_0072();

        System.out.println(q.minDistance("abc", "bcd"));
    }

    /*动态规划的思想 dp[i][j] 代表 word1 中前 i 个字符，变换到 word2 中前 j 个字符，最短需要操作的次数
    需要考虑 word1 或 word2 一个字母都没有，即全增加/删除的情况，所以预留 dp[0][j] 和 dp[i][0]*/
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {  // 这两个是表示另一个字符串为空的情况的操作
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {  // 如果相同就无需更改
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;// dp[i][j] = dp[i-1][j]表示增加删除一个字符 dp[i][j-1]表示增加一个字符 dp[i-1][j-1]表示更改一个字符
                }

            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
