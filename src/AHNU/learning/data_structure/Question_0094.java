package AHNU.learning.data_structure;

/*
    给定一个二叉树的根节点 root ，返回它的 中序 遍历。
*/


import java.util.*;

public class Question_0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {  // 如果root不为空就把左节点一路遍历到底 并且把节点存入栈中
                stk.push(root);
                root = root.left;
            }
            root = stk.pop(); // 此时节点为null pop一个栈中的节点作为根节点 并把节点数据存入list
            res.add(root.val);
            root = root.right; // 看此时的节点有没有右节点
        }
        return res;
    }
}
