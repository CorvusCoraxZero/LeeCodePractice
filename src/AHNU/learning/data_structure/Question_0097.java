package AHNU.learning.data_structure;

/*
    给定一个二叉树，判断其是否是一个有效的二叉搜索树。

    假设一个二叉搜索树具有如下特征：

    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。

*/


import java.util.*;

public class Question_0097 {

    /**
     * 解题思路！！  重要知识点： 根据二叉搜索树的定义 二叉搜索树的中序遍历为升序
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE; // pre表示上一个遍历的节点数据 如果当前节点的数据小于上一个节点的数据 则证明该二叉树不是二叉搜索树
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre < root.val){
                pre = root.val;
            }else {
                return false;
            }
            root = root.right;
        }
        return true;
    }
}
