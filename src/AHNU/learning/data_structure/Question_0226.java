package AHNU.learning.data_structure;

/*
   翻转一棵二叉树。

   输入：
             4
           /   \
          2     7
         / \   / \
        1   3 6   9
    输出：
             4
           /   \
          7     2
         / \   / \
        9   6 3   1

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/invert-binary-tree
*/

public class Question_0226 {

    public static void main(String[] args) {
        Question_0226 q = new Question_0226();
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix2 = new char[][]{{'0', '1'}};

        System.out.println(q.maximalSquare(matrix2));
    }

    // 递归解题
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        if (root.right == null && root.left == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
