package AHNU.learning.data_structure;

    /*给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/regular-expression-matching*/

    public class Question_0010 {


        public static void main(String[] args) {
            /*String s = "mississippi";
            String p = "mis*is*p*.";*/

            String s = "aab";
            String p = "aab";

            Question_0010 q = new Question_0010();
            System.out.println(q.isMatch(s,p));
        }

        //本题采用动态规划的方式来求解
        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return false;
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];  // 动态规划的表 用于表示s的前i个数能否被p的前j个数匹配
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) { // 初始化 a*串打头不匹配被去掉的情况
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true; // here's y axis should be i+1
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){  // 最简单的情况直接相等匹配上
                        dp[i + 1][j + 1] = dp[i][j];
                    }else if (p.charAt(j) == '*'){ // 这里一共有两种情况为true 前一个匹配上 前一个匹配不上
                        if (s.charAt(i) == p.charAt(j -1) || p.charAt(j -1) == '.'){
                            dp[i + 1][j + 1] = (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1]);
                        }else if (s.charAt(i) != p.charAt(j -1)){ // 前一个匹配不上 但是可以利用*干掉这个 看能否匹配
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        }
                        /*
                        *      dp[i + 1][j + 1] = dp[i][j + 1] // 多个字符匹配的情况
                            or dp[i + 1][j + 1] = dp[i + 1][j] // 单个字符匹配的情况
                            or dp[i + 1][j + 1] = dp[i + 1][j - 1] // 没有匹配的情况 就是 去掉多余的 b *，p 本身之前的能否匹配，###b 和 ### 是否匹配
                        */
                    }else dp[i + 1][j + 1] = false;
                }
            }

            return dp[s.length()][p.length()];
        }
}
