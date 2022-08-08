package AHNU.learning.data_structure;

/*
    给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用原地算法。

    示例 1：
        输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        输出：[[1,0,1],[0,0,0],[1,0,1]]

    示例 2：
        输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

    提示：
        m == matrix.length
        n == matrix[0].length
        1 <= m, n <= 200
        -231 <= matrix[i][j] <= 231 - 1

    进阶：
        一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
        一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
        你能想出一个仅使用常量空间的解决方案吗？

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/set-matrix-zeroes
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question_0073 {

    public static void main(String[] args) {
        Question_0073 q = new Question_0073();
        int[][] nums = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        q.setZeroesNew(nums);
        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    // m+n的额外空间的做法
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> cloumnSet = new HashSet<>();

        // 记录所有的需要置零的行和列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    cloumnSet.add(j);
                }
            }
        }

        for (Integer row : rowSet) {
            Arrays.fill(matrix[row], 0);
        }

        for (Integer column : cloumnSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }

        return;
    }

    // 常数个额外空间的做法
    public void setZeroesNew(int[][] matrix) {
        // 遍历数据 如果当前行有元素为0直接置零
        // 利用第一个置零的行来存储要置零的列的信息
        boolean firsZero = false;
        boolean cleanRow;
        int dateRow = 0;
        // 找到第一个为0的数
        for (int i = 0; i < matrix.length; i++) {
            cleanRow = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // 使第一个0出现的行为数据行 存放数据
                    if (!firsZero) {
                        firsZero = true;
                        dateRow = i;
                        break;
                    }
                    matrix[dateRow][j] = 0;
                    cleanRow = true;
                }
            }
            if (cleanRow) {
                Arrays.fill(matrix[i], 0);
            }
        }

        if (firsZero) {
            // 遍历数据行 清空数据行 和 清空记录的列
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[dateRow][i] != 0) {
                    matrix[dateRow][i] = 0;
                } else {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
}


