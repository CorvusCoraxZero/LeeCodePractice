package AHNU.learning.data_structure;

/*
    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

    输入: [3,2,3,null,3,null,1]

         3
        / \
       2   3
        \   \
         3   1

    输出: 7
    解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/house-robber-iii
*/

import java.util.HashMap;

public class Question_0337 {

    HashMap<TreeNode,Integer> choose = new HashMap<>();  // 当前节点选中的情况的最大点数的表
    HashMap<TreeNode,Integer> miss = new HashMap<>();    // 当前节点不选中的情况的最大点数的表

    public static void main(String[] args) {
        Question_0337 q = new Question_0337();
        System.out.println(q.rob(TreeNode.getTreeFirst())); // 3 2 null 3 null null 3 null 1 null null
    }

    // 动态规划解题 递归自底向上求解
    public int rob(TreeNode root) {
        choose.put(null,0);
        miss.put(null,0);
        dfs(root);
        return Math.max(choose.get(root),miss.get(root));
    }

    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        if (node.right != null) dfs(node.right);
        if (node.left != null) dfs(node.left);
        choose.put(node,miss.get(node.right)+miss.get(node.left) + node.val);
        miss.put(node,Math.max(choose.get(node.right),miss.get(node.right)) + Math.max(choose.get(node.left),miss.get(node.left)));

        return;
    }
}