package AHNU.learning.data_structure;

    /*给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/regular-expression-matching*/

    public class Question_0010 {


        public static void main(String[] args) {
            String s = "abcd";
            String p = "abb*cd";

            Question_0010 q = new Question_0010();
            System.out.println(q.isMatch(s,p));
            System.out.println(q.isMatch2(s,p));
        }

        //本题采用动态规划的方式来求解
        public boolean isMatch(String s, String p) {
            if (s == null && p == null) return false;
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];  // 动态规划的表 用于表示s的前i个数能否被p的前j个数匹配
            dp[0][0] = true;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){  // 最简单的情况直接相等匹配上
                        dp[i + 1][j + 1] = dp[i][j];
                    }else if (p.charAt(j) == '*'){ // 这里一共有三种情况为true 前一个匹配上 前一个匹配不上 但是可以干掉匹配上
                        if (s.charAt(i) == p.charAt(j -1) && p.charAt(j -1) == '.'){
                            dp[i + 1][j + 1] = dp[i][j - 1];
                        }else if (s.charAt(i) != p.charAt(j -1) && s.charAt(i) != p.charAt(j -2)){ // 前一个匹配不上 但是可以利用*干掉这个 和前一个匹配上
                            dp[i + 1][j + 1] = dp[i][j - 2];
                        }
                    }else dp[i + 1][j + 1] = false;
                }
            }

            return dp[s.length()][p.length()];
        }




































        public boolean isMatch2(String s,String p){
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
            for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true; // here's y axis should be i+1
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
}
