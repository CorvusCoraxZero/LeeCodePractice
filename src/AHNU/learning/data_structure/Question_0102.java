package AHNU.learning.data_structure;

/*
    给定一个二叉树，判断其是否是一个有效的二叉搜索树。

    假设一个二叉搜索树具有如下特征：

    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
*/


import java.util.*;

public class Question_0102 {

    public static void main(String[] args) {
        Question_0102 q = new Question_0102();
        TreeNode tree = TreeNode.getTree();
        List<List<Integer>> l = q.levelOrder(tree);
        for (List<Integer> integers : l) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    /**
     * 递归解法 用栈记录每一层的数据
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            stack.add(root);
        }
        levelOrderRe(stack,list);
        return list;
    }

    public void levelOrderRe(ArrayDeque<TreeNode> stackP, List<List<Integer>> list) {
        if (stackP.isEmpty()){
            return;
        }
        List<Integer> layer = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stackP.isEmpty()) {
            TreeNode node = stackP.pop();
            layer.add(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null){
                stack.add(node.right);
            }
        }
        list.add(layer);
        levelOrderRe(stack,list);
        return;
    }

    /**
     * 使用一个二元组 (node, level) 来表示状态，它表示某个节点和它所在的层数，每个新进队列的节点的 level 值都是父亲节点的 level 值加一。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

}
