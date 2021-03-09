package AHNU.learning.data_structure;

/*
    给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

    说明：
        拆分时可以重复使用字典中的单词。
        你可以假设字典中没有重复的单词。

*/

import java.util.*;

public class Question_0139 {

    public static void main(String[] args) {
        Question_0139 q = new Question_0139();
        List<String> wordDict = new ArrayList<String>(Arrays.asList("apple", "pen"));
        System.out.println(q.wordBreak2("applepenapple",wordDict));
    }

    // 采用动态规划的方法解题 状态转移方程 dp[i] = dp[j] && wd.contian()
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wd = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];  // 动态规划数组 第i个元素为true表示 s[0-i-1]可以被合法的拆分
        dp[0] = true;  // 对于边界条件，我们定义 dp[0]=true 表示空串且合法。
        for (int i = 1; i < s.length()+1; i++) { // 从第一个字符开始搜索
            for (int j = 0; j < i; j++) {

                if (dp[j] && wd.contains(s.substring(j,i))){ // substring切割下j开始到i-1的字符 也就是以j开头的i-j个字符
                    dp[i] = true;
                }

            }
        }
        return dp[s.length()];
    }

    // 对上个版本进行剪枝操作 如果i-j的长度大于最长的单词就跳过 小于最小的单词就跳过
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wd = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];  // 动态规划数组 第i个元素为true表示 s[0-i-1]可以被合法的拆分

        // 遍历列表获得最大最小长度；
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        for (String s1 : wordDict) {
            if (s1.length() > maxLength) maxLength = s1.length();
            if (s1.length() < minLength) minLength = s1.length();
        }

        dp[0] = true;  // 对于边界条件，我们定义 dp[0]=true 表示空串且合法。
        for (int i = 1; i < s.length()+1; i++) { // 从第一个字符开始搜索
            for (int j = Math.max(i-maxLength,0); i-j >= minLength; j++) {  // 直接从剩余最大单词长度处开始遍历 切割下的字符串的长度小于最小的单词长度时就结束遍历

                if (dp[j] && wd.contains(s.substring(j,i))){ // substring切割下j开始到i-1的字符 也就是以j开头的i-j个字符
                    dp[i] = true;
                }

            }
        }
        return dp[s.length()];
    }
}
