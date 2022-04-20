package AHNU.learning.data_structure;

/*
    编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。
    
    示例 1：
        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        输出：true

    示例 2：
        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        输出：false

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/search-a-2d-matrix
*/

public class Question_0074 {

    public static void main(String[] args) {
        Question_0074 q = new Question_0074();
        // int[][] nums = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] nums = new int[][]{{1,3}};
        int target = 3;
        System.out.println(q.searchMatrix(nums, 3));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        // 折半查找到所在行
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                left = mid;
            } else if (matrix[mid][0] == target) {
                return true;
            }
        }
        int row = matrix.length >= 2 ? left : 1;
        if (matrix.length >= 2){
            row = left;
        }else {
            row = 0;
            if (matrix[row][0] == target) return true;
        }
        // 折半查找到所在列
        left = 0;
        right = matrix[row].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}

