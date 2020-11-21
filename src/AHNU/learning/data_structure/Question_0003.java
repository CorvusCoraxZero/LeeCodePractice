package AHNU.learning.data_structure;

/*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
*/

import java.util.Scanner;

public class Question_0003 {

    public static void main(String[] args) {
        Question_0003 q3 = new Question_0003();
        Scanner sc = new Scanner(System.in);
        //String str = sc.next();
        System.out.println(q3.lengthOfLongestSubstring("a"));
    }

    /*public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int from = 0, to = 1, length = 1, maxLength = 1;
        // to遍历直到字符串末尾
        while (to < s.length()){
            int site = s.substring(from, to).indexOf(s.charAt(to));  // 下一个字符对应的字串内相同的字符的坐标
            if (site != -1){
                // to指向的字符已存在
                length = to - from;
                if (length > maxLength) maxLength = length;
                // from 跳转到site+1的位置
                from = from + site + 1;
            }
            to++;
        }
        // 处理最后一个子串
        if (to - from > maxLength) {
            maxLength = to - from;
        }
        return maxLength;
    }*/

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0 ) return 0;
        if (s.length() == 1 ) return 1;
        int from = 0, to = 0, same = -1, maxLength = 1; // from to 表示子串开头和结尾 same表示和子串相同字符的坐标 也就是from下次跳转的坐标的前一个
        char now;
        while (true){
            now = s.charAt(to + 1);
            for (int i = from; i <= to; i++) {  //查找from和to之间有没有和下一字符相同的租房有
                if (s.charAt(i) == now){    // 记录相同字符坐标
                    same = i;
                    break;
                }
            }
            if (same != -1){  //字符串内有与下个字符相同的字符 记录字串长度 与最大字串比较 并且from跳转到该字符后
                if (maxLength < (to - from + 1)){
                    maxLength = to - from + 1;
                }
                from = same + 1;
            }
            to++;
            if ((s.length() - from) < maxLength){ // 如果未检测的长度小于 最大字串长度退出循环
                break;
            }
            if ((s.length() - to) <= 1){  //处理最后一个字符串
                if (maxLength < (s.length() - from)){
                    maxLength = s.length() - from;
                }
                break;
            }
        }
        return maxLength;
    }

}
