package AHNU.learning.data_structure;

/*
    给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

    示例 1：
        输入：root = [3,9,20,null,null,15,7]
        输出：[[3],[20,9],[15,7]]

    示例 2：
        输入：root = [1]
        输出：[[1]]

    示例 3：
        输入：root = []
        输出：[]

    提示：
    树中节点数目在范围 [0, 2000] 内
    -100 <= Node.val <= 100

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal
*/

import java.util.*;

public class Question_0103 {

    public static void main(String[] args) {
        Question_0103 q = new Question_0103();
        TreeNode treeNode = TreeNode.getTreeLayer();
        for (List<Integer> list : q.zigzagLevelOrder(treeNode)) {
            for (Integer integer : list) {
                System.out.println(integer + " ");
            }
            System.out.println(" ");
        }


    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}

