package AHNU.learning.data_structure;

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
    输入：n = 3
    输出：[ "((()))",
           "(()())",
           "(())()",
           "()(())",
           "()()()" ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_0022 {

    public static void main(String[] args) {
        Question_0022 q = new Question_0022();
        List<String> list = q.generateParenthesis(100);
        for (String s : list) {
            System.out.println(s);
        }
    }

    // 使用递归+栈 递归返回的是剩下的字符串
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();  // 结果的容器哦
        ArrayList<Character> stack = new ArrayList<>(); // 栈
        StringBuilder str = new StringBuilder();

        if (n == 0) return list;
        stack.add('(');
        str.append('(');
        generate(list, stack, str, n - 1, n);
        return list;
    }

    public void generate(ArrayList<String> list, ArrayList<Character> stack, StringBuilder str, int n, int m) { //  n表示还可以压入栈中的'('的个数，m表示还可以压入填入的')'的个数
        int ss = stack.size();
        if (n == 0) {   // 如果没有'('可以加了 则添加上剩余的')'就可以返回了
            for (int i = 0; i < m; i++) {
                str.append(')');
            }
            list.add(str.toString());
            for (int i = 0; i < m + 1; i++) {
                str.delete(str.length()-1, str.length());
            }
            return;
        } else if (n >= 1) {    // 如果还有'('可以加
            if (stack.size() == 0) { //如果栈为空 就只有一种选择 加'('
                str.append('(');
                stack.add('(');
                generate(list, stack, str, n - 1, m);
            }
            else if (stack.get(stack.size() - 1) == '(') { // 如果栈顶元素为'(' 其实就是栈不空的话
                //情况1 填入'('
                str.append('(');
                stack.add('(');
                generate(list, stack, str, n - 1, m);

                //情况2 填入')'
                str.append(")");
                stack.remove(stack.size()-1); // 第一个弹出是将上面操作后的栈回原
                stack.remove(stack.size()-1); // 第二个是弹出当前的'('
                generate(list,stack,str,n,m-1);
            }
        }

        // 将栈和StringBuilder恢复到刚进入函数时的状态
        if (ss < stack.size()){
            stack.remove(stack.size() -1 );
        }else if (ss > stack.size()){
            stack.add('(');
        }
        str.delete(str.length() -1, str.length());
    }
}
