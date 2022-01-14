package AHNU.learning.data_structure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/*
    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

    示例 1:
        输入: s = "cbaebabacd", p = "abc"
        输出: [0,6]
        解释:
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    示例 2:
        输入: s = "abab", p = "ab"
        输出: [0,1,2]
        解释:
        起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
        起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
        起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
*/

public class Question_0438 {

    public static void main(String[] args) {
        Question_0438 q = new Question_0438();
        String str = "cbaebabacd";
        String p = "abc";
        List<Integer> list = q.findAnagrams(str, p);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    // 使用滑动窗口的方法解题
    public List<Integer> findAnagrams(String s, String p) {
        // 结果
        ArrayList<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        // 初始化窗口
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        // 窗口原始数据
        LinkedHashMap<Character, Integer> standard = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            if (map.containsKey(p.charAt(i))) {
                map.replace(p.charAt(i), map.get(p.charAt(i)) + 1);
                standard.replace(p.charAt(i), map.get(p.charAt(i)) + 1);
            } else {
                map.put(p.charAt(i), 1);
                standard.put(p.charAt(i), 1);
            }
        }
        // 将窗口放进s上
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
            int headIndex = i - p.length() + 1;

            boolean flag = true;
            for (Integer value : map.values()) {
                if (value != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(headIndex);
            }

            // i >= p.length 时可以开始滑动删减头部
            if (i >= p.length() - 1) {
                if (standard.containsKey(s.charAt(headIndex))) {
                    map.replace(s.charAt(headIndex), map.get(s.charAt(headIndex)) + 1);
                }
            }
        }
        return result;
    }
}



