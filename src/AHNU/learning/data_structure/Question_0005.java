package AHNU.learning.data_structure;

/*
    给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
    进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays

*/

public class Question_0005 {

    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int le = 0; le < n; ++le) {
            for (int i = 0; i + le < n; ++i) {
                int j = i + le;
                if (le == 0) {
                    dp[i][j] = true;
                } else if (le == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && le + 1 > ans.length()) {
                    ans = s.substring(i, i + le + 1);
                }
            }
        }
        return ans;
    }


}
