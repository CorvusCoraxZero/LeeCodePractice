package AHNU.learning.data_structure;

/*
    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

    输入: "(()"
    输出: 2
    解释: 最长有效括号子串为 "()"
    示例 2:

    输入: ")()())"
    输出: 4
    解释: 最长有效括号子串为 "()()"

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-valid-parentheses
*/

import java.util.Arrays;

public class Question_0032 {

    public static void main(String[] args) {
        Question_0032 q = new Question_0032();

    }

    // 使用动态规划的思想来解题 时间复杂度O(n) 空间复杂度O(n)
    /*
    s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘(’}s[i−1]=‘(’，也就是字符串形如 “……()”“……()”，我们可以推出：

    \textit{dp}[i]=\textit{dp}[i-2]+2
    dp[i]=dp[i−2]+2

    我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 22 。

    s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘)’}s[i−1]=‘)’，也就是字符串形如 “……))”“……))”，我们可以推出：
    如果 s[i - \textit{dp}[i - 1] - 1] = \text{‘(’}s[i−dp[i−1]−1]=‘(’，那么

    \textit{dp}[i]=\textit{dp}[i-1]+\textit{dp}[i-\textit{dp}[i-1]-2]+2
    dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2

    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
    来源：力扣（LeetCode）
    */
    public int longestValidParentheses(String s) {

    }

}
