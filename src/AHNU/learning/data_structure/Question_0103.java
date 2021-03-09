package AHNU.learning.data_structure;

/*
    给定一个二叉树，找出其最大深度。

    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

    说明: 叶子节点是指没有子节点的节点。
*/


import java.util.*;

public class Question_0103 {

    public static void main(String[] args) {
        Question_0103 q = new Question_0103();
        TreeNode tree = TreeNode.getTree();
        System.out.println(q.maxDepth(tree));

    }

    /**
     * 递归解法 用栈记录每一层的数据
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            stack.add(root);
        }
        return levelOrderRe(stack, list);
    }

    public int levelOrderRe(ArrayDeque<TreeNode> stackP, List<List<Integer>> list) {
        if (stackP.isEmpty()) {
            return 0;
        }
        List<Integer> layer = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stackP.isEmpty()) {
            TreeNode node = stackP.pop();
            layer.add(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        list.add(layer);
        return levelOrderRe(stack, list) + 1;
    }
}
