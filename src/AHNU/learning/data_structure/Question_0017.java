package AHNU.learning.data_structure;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
*/


import java.util.*;

public class Question_0017 {

    public static void main(String[] args) {
        String s = "234";
        Question_0017 q = new Question_0017();
        List<String> list = q.letterCombinations(s);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    // 循环n次  通过控制 存储目前位置的index数组每次为答案添上一个字符串
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        char[][] table = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        int[] nums = new int[digits.length()];
        int[] lengths = new int[digits.length()];
        int count = 1;
        int[] index = new int[digits.length()];

        if (digits == null || digits.length() == 0) return list;  // 如果输入为空 返回空链表

        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i) - '0' - 2;
            lengths[i] = table[nums[i]].length ;
            count *= lengths[i];
        }


        StringBuilder str;
        for (int i = 0; i < count; i++) {
            for (int j = index.length - 1; j >= 0; j--) {   // 更新当前坐标
                if (index[j] > lengths[j] - 1){
                    index[j] = 0;
                    index[j-1] += 1;
                }
            }
            str = new StringBuilder();
            for (int j = 0; j < digits.length(); j++) { // 生成字符串
                str.append(table[nums[j]][index[j]]);
            }
            index[digits.length() - 1]++;
            list.add(str.toString());  // 将字符串写入list
        }
        return list;
    }

    // 官方给出的回溯的解法
    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
