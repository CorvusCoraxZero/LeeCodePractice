package AHNU.learning.data_structure;

import java.util.ArrayList;
import java.util.List;

/*
    两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
    给你两个整数 x 和 y，计算并返回它们之间的汉明距离。

    示例 1：
        输入：x = 1, y = 4
        输出：2
        解释：
        1   (0 0 0 1)
        4   (0 1 0 0)
               ↑   ↑
        上面的箭头指出了对应二进制位不同的位置。

    示例 2：
        输入：x = 3, y = 1
        输出：1

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/hamming-distance
*/

public class Question_0461 {

    public static void main(String[] args) {
        Question_0461 q = new Question_0461();
        System.out.println(q.hammingDistance(1, 3));
    }

    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int count = 0;
        while (i > 0) {
            if (i % 2 == 1){
                count++;
            }
            i /= 2;
        }
        return count;
    }
}



