package AHNU.learning.data_structure;

/*
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/group-anagrams
*/

import java.util.*;

public class Question_0049 {

    public static void main(String[] args) {
        Question_0049 q = new Question_0049();

        String[] strs = {"abc", "asd", "cba", "bac", "cde", "ced", "asd", "asdf"};
        List<List<String>> lists = q.groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }

    // 比较每个String 的 排序字符串
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length <= 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(String.valueOf(chars))) {
                map.put(String.valueOf(chars), new ArrayList<String>());
            }
            map.get(String.valueOf(chars)).add(s);
        }
        return new ArrayList(map.values());
    }

    //  通过一个数组记录每个字符串中每个字符出现的次数 然后将这个数组转化为字符串 作为map的key 时间上来说的话这个更快
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length <= 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(String.valueOf(chars))) {
                map.put(String.valueOf(chars), new ArrayList<String>());
            }
            map.get(String.valueOf(chars)).add(s);
        }
        return new ArrayList(map.values());
    }
}
