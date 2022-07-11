package AHNU.learning.data_structure;

/*
    罗马数字包含以下七种字符:I，V，X，L，C，D和M。

    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。
    这个特殊的规则只适用于以下六种情况：
        I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
        X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
        C可以放在D(500) 和M(1000) 的左边，来表示400 和900。

    示例1:
        输入:s = "III"
        输出: 3

    示例2:
        输入:s = "IV"
        输出: 4

    示例3:
        输入:s = "IX"
        输出: 9

    示例4:
        输入:s = "LVIII"
        输出: 58
        解释: L = 50, V= 5, III = 3.

    示例5:
        输入:s = "MCMXCIV"
        输出: 1994
        解释: M = 1000, CM = 900, XC = 90, IV = 4.

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/roman-to-integer
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question_0013 {

    public static void main(String[] args) {
        Question_0013 q = new Question_0013();
        String input = "LVIII";
        System.out.println(input + " " + q.romanToInt(input));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char next, now;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if (i + 1 < s.length()) {
                next = s.charAt(i + 1);
            } else {
                next = '0';
            }
            if ((now == 'I' && (next == 'V' || next == 'X')) || (now == 'X' && (next == 'L' || next == 'C')) || (now == 'C' && (next == 'D' || next == 'M'))) {
                result -= map.get(now);
            } else {
                result += map.get(now);
            }
        }
        return result;
    }

}
