package AHNU.learning.data_structure;

/*
    给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
    返回所有可能的结果。答案可以按 任意顺序 返回。

    示例 1:
        输入: "()())()"
        输出: ["()()()", "(())()"]

    示例 2:
        输入: "(a)())()"
        输出: ["(a)()()", "(a())()"]

    示例 3:
        输入: ")("
        输出: [""]
     
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
    */

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.*;

public class Question_0301 {

    public static void main(String[] args) {
        Question_0301 q = new Question_0301();
        String str = "()())()";
        List<String> list = q.removeInvalidParentheses(str);
        for (String s : list) {
            System.out.println(s);
        }

    }

    // 深度遍历 + 剪枝的思想 核心思路是 当前坐标前面的右括号比左括号多的时候 当前字串为不合法
    public List<String> removeInvalidParentheses(String s) {
        // 为了进行剪枝操作 要确定出要删去的左括号和右括号的个数
        int subLift=0,subRight=0;// 记录要删去的左括号和右括号的个数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==')'){
                if (subLift == 0){
                    subRight++;
                }else {
                    subLift--;
                }
            } else if (s.charAt(i)=='('){
                subLift++;
            }else{
                continue;
            }
        }

        // 深度遍历
        HashSet<String> set = new HashSet<>();
        dfs(s,new StringBuilder(),0,0,0,subLift,subRight,set);
        return new ArrayList<>(set);
    }

    /**
     * @param str 当前字符串
     * @param result 结果字符串
     * @param index 遍历到的位置
     * @param leftCount 已经遍历过的左括号个数
     * @param rightCount 已经遍历过的右括号个数
     * @param left 需要减去的左括号的个数
     * @param right 需要减去的右括号的个数
     * @param set 结果集
     */
    // 只有当「已经遍历到的左括号的数量」严格大于「已经遍历到的右括号的数量」的时候，才可以继续添加「右括号」
    public void dfs(String str,StringBuilder result, int index,int leftCount,int rightCount, int left, int right, Set<String> set){
        // 如果已经遍历到字符串结尾 将结果放入set中
        if (index == str.length()){
            if (left == 0 && right == 0){
                set.add(result.toString());
            }
            return;
        }

        // 如果是左括号
        if (str.charAt(index) == '(' ){
            if (left > 0){
                // 删除
                dfs(str,new StringBuilder(result.toString()),index + 1,leftCount, rightCount ,left - 1,right,set);
            }
            // 不删除
            result.append(str.charAt(index));
            dfs(str,result,index + 1,leftCount + 1, rightCount ,left,right,set);
        } // 如果是右括号 right>0 的情况
        else if (str.charAt(index) == ')' ){
            // 删除
            if (right > 0){
                dfs(str,new StringBuilder(result.toString()),index + 1,leftCount, rightCount, left,right - 1,set);
            }
            if (leftCount > rightCount){
                // 不删除
                result.append(str.charAt(index));
                dfs(str,result,index + 1,leftCount, rightCount+ 1,left,right,set);
            }
        }

        // 当前字符如果是其他字符,把当前字符直接添加到result中
        else if ((str.charAt(index) != '(' && str.charAt(index) != ')')){
            result.append(str.charAt(index));
            dfs(str,result,index + 1,leftCount,rightCount,left,right,set);
        }
        return;
    }
}