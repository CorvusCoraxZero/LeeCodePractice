package AHNU.learning.data_structure;

/*
    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

    示例 1：
        输入：s = "ADOBECODEBANC", t = "ABC"
        输出："BANC"
    示例 2：
        输入：s = "a", t = "a"
        输出："a"
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question_0076 {

    public static void main(String[] args) {
        Question_0076 q = new Question_0076();
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(q.minWindow(s, t));
    }

    /* 采用滑动窗口的方式解题 */
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();      // 表示t字符串中所有字符的map
        Map<Character, Integer> winMap = new HashMap<>();    // 表示当前滑动窗口中包含的所有字符的map
        int left = 0, right = 0;  // 滑动窗口的坐标
        int length = Integer.MAX_VALUE;  // 记录最小的字串长度
        String result = "";

        for (int i = 0; i < t.length(); i++) {  // 为tMap赋值
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (left <= s.length() - t.length() && right < s.length()) {
            if (!check(tMap, winMap)) {
                winMap.put(s.charAt(right), winMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            while (check(tMap, winMap)){
                if (length > right - left) {
                    length = right - left;
                    result = s.substring(left,right);
                }
                winMap.put(s.charAt(left), winMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }

        return result;
    }

    public boolean check(Map tMap, Map winMap) {  // 检测当前窗口是否符合要求
        Iterator iter = tMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if ((int) winMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    /* 别人的代码 更加简洁高效 */
    public String minWindow2(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c :  t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 判断取出的字符是否在字串中
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).intValue()==need.get(c).intValue()) {
                    valid++;
                }
            }

            // 判断是否需要收缩（已经找到合适的覆盖串）
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).intValue()==need.get(c1).intValue()) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
