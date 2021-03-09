package AHNU.learning.data_structure;

/*
    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

    示例:
        输入: 3
        输出: 5
*/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question_0096 {
    public static void main(String[] args) {
        Question_0096 q = new Question_0096();
        System.out.println(q.numTrees(4));
    }

    // 固定根节点 左右孩子分别为 数量为a 和 b 的子树 a+b=n-1
    // 采用动态规划的方式解题 n0=1 n1=1 n2=(n0*n1)+(n1*n0) n3=(n0*n2)+(n1*n1)+(n2*n0)
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += result[j] * result[i - j - 1];
            }
            result[i] = sum;
        }
        return result[n];
    }
}
