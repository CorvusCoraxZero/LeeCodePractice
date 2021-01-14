package AHNU.learning.data_structure;

/*
    给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。

    示例 1：

    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    示例 2：

    输入：nums = [0]
    输出：[[],[0]]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/subsets
*/


import java.util.ArrayList;
import java.util.List;

public class Question_0079 {

    public static void main(String[] args) {
        Question_0079 q = new Question_0079();
        //char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = new char[][]{{'A'}};
        String word = "S";
        System.out.println(q.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    //找到第一个字母 通过递归进行深度优先遍历 查找是否有匹配的字符
                    if (word.length() <= 1) return true;
                    board[i][j] = (char) (board[i][j] - 58);
                    if (existRec(i, j, 1, word, board)) {
                        return true;
                    }
                    board[i][j] = (char) (board[i][j] + 58);
                }
            }
        }
        return false;
    }

    // 使用回溯 修改board的值-58 变为无效字符
    public boolean existRec(int x, int y, int index, String word, char[][] board) { // index 表示当前查找字母在字符串中位置
        int tx = x, ty = y;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0: tx = x - 1;ty = y;break;
                case 1: tx = x + 1;ty = y;break;
                case 2: tx = x;ty = y - 1;break;
                case 3: tx = x;ty = y + 1;break;
            }
            if (tx >= 0 && ty >= 0 && tx < board.length && ty < board[tx].length && board[tx][ty] == word.charAt(index)) {
                if (index + 1 == word.length()){
                    return true;
                }else{
                    board[tx][ty] = (char) (board[tx][ty] - 58);
                    if (existRec(tx, ty, index + 1, word, board)) {
                        return true;
                    }
                    board[tx][ty] = (char) (board[tx][ty] + 58);
                }
            }
        }
        return false;
    }
}
