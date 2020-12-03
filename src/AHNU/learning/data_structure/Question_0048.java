package AHNU.learning.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   给定一个 n × n 的二维矩阵表示一个图像。
    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

    [1,2,3],        [7,4,1],
    [4,5,6],  -->   [8,5,2],
    [7,8,9]         [9,6,3]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/rotate-image
*/

public class Question_0048 {

    public static void main(String[] args) {
        Question_0048 q = new Question_0048();

    }

    // 逐层旋转  这是官方解题 思路一样 没有时间了就没有写
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2 + n % 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int[] tmp = new int[4];
                    int row = i;
                    int col = j;
                    for (int k = 0; k < 4; k++) {
                        tmp[k] = matrix[row][col];
                        int x = row;
                        row = col;
                        col = n - 1 - x;
                    }
                    for (int k = 0; k < 4; k++) {
                        matrix[row][col] = tmp[(k + 3) % 4];
                        int x = row;
                        row = col;
                        col = n - 1 - x;
                    }
                }
            }
        }
    }
}
