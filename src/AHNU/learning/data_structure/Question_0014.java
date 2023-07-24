package AHNU.learning.data_structure;

import java.util.Arrays;

/*
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    示例 1：
        输入：strs = ["flower","flow","flight"]
        输出："fl"

    示例 2：
        输入：strs = ["dog","racecar","car"]
        输出：""
        解释：输入不存在公共前缀。

    提示：
        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] 仅由小写英文字母组成
*/
public class Question_0014 {

    public static void main(String[] args) {
        Question_0014 q = new Question_0014();
        String[] input = {"flower","flow","flight"};
        System.out.println(q.longestCommonPrefix(input));
    }

    public String longestCommonPrefix(String[] strs) {
        int resultLength = strs[0].length();
        char[] result = Arrays.copyOf(strs[0].toCharArray(),200);
        for(int i = 1; i < strs.length; i++){
            String nowStr = strs[i];
            if(nowStr.length() < resultLength){
                resultLength = nowStr.length();
            }
            for(int j = 0; j < resultLength; j++){
                if(nowStr.charAt(j) == result[j]){
                    continue;
                }else{
                    resultLength = j;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < resultLength; i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }

}
