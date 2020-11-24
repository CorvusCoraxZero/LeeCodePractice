package AHNU.learning.data_structure;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Question_0020 {

    public static void main(String[] args) {
        Question_0020 q = new Question_0020();

        String str = "[([]])";
        System.out.println(q.isValid(str));
    }

    // 使用栈 遇见相对的括号就弹出 不相对的就压入 结束时如果为空则为真  可能为了省事用了ArrayList 效率慢了点 改成数组下标来做应该效率更高
    public boolean isValid(String s) {
        char c;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (list.size() == 0){  // 栈为空压入
                list.add(c);
            }else if ((list.get(list.size() - 1) == '(' && c == ')') || (list.get(list.size() - 1) == '[' && c == ']') || (list.get(list.size() - 1) == '{' && c == '}')){  // 否则就弹出
                list.remove(list.size() - 1);
            }else list.add(c); // 不相对就压入
        }
        if (list.size() == 0){
            return true;
        }else return false;
    }

}
