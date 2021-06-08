package AHNU.learning.data_structure;

/*
    给你二叉树的根结点 root ，请你将它展开为一个单链表：

    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    展开后的单链表应该与二叉树 先序遍历 顺序相同。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
*/


public class Question_0114 {

    public static void main(String[] args) {
        Question_0114 q = new Question_0114();
        TreeNode tree = TreeNode.getTreeLayer();
        q.flatten(tree);
    }

    /**
     * 参考官方第三解法找到当前节点左子树中序遍历的最终点（即左子树最右侧的节点）然后将当前节点的右子树移动到最终点的右节点上
     * 然后将当前节点的左子树设为右子树 然后当前节点变为右子树的根节点 如此循环
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null || root.right == null && root.left == null) return;
        TreeNode current = root; // 当前节点
        TreeNode index = null;   // 当前节点的右子树要接上的坐标 也就是当前节点左子树最右侧节点
        while (current != null){
            if (current.left != null){
                index = current.left;
                while (index.right != null || index.left != null){
                    if (index.right != null){
                        index = index.right;
                    }else if (index.left != null){
                        index = index.left;
                    }
                }
                index.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
