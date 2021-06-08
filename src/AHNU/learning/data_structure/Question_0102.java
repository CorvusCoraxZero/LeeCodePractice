package AHNU.learning.data_structure;

/*
    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
*/


import java.util.*;

public class Question_0102 {

    public static void main(String[] args) {
        Question_0102 q = new Question_0102();
        TreeNode tree = TreeNode.getTreeLayer();
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
