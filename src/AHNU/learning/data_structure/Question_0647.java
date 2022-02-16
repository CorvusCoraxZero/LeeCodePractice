package AHNU.learning.data_structure;

/*
    给你一个字符串s，请你统计并返回这个字符串中回文子串的数目。
    回文字符串是正着读和倒过来读一样的字符串。
    子字符串 是字符串中的由连续字符组成的一个序列。
    具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

    示例 1：
        输入：s = "abc"
        输出：3
        解释：三个回文子串: "a", "b", "c"
    示例 2：
        输入：s = "aaa"
        输出：6
        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/palindromic-substrings
*/

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Question_0647 {

    public static void main(String[] args) {
        Question_0647 q = new Question_0647();
       String str = "";
        System.out.println(q.countSubstrings(str));
    }


    // 使用遍历回文中心的方法
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            // 相当经典的操作 从而将奇偶数两种不同情况合为一种情况
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}



