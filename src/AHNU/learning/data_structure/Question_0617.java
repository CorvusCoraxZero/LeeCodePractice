package AHNU.learning.data_structure;

/*
    给你两棵二叉树： root1 和 root2 。
    想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
    返回合并后的二叉树。

    示例 1：
        输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        输出：[3,4,5,5,4,null,7]
    示例 2：
        输入：root1 = [1], root2 = [1,2]
        输出：[2,2]

    注意: 合并过程必须从两个树的根节点开始。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-two-binary-trees
*/

public class Question_0617 {

    public static void main(String[] args) {
        Question_0617 q = new Question_0617();
        TreeNode root1 = TreeNode.getTreeLayer();
        // 1 3 2 5 #
        TreeNode root2 = TreeNode.getTreeLayer();
        // 2 1 3 ! 4 ! 7 #
        System.out.println(q.mergeTrees(root1, root2));
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        TreeNode result = new TreeNode(0);
        rcMerge(root1,root2,result);
        return result;
    }

    public void rcMerge(TreeNode r1, TreeNode r2, TreeNode node) {
        TreeNode left1, left2,right1,right2;
        if (r1 != null) {
            node.val += r1.val;
            left1 = r1.left;
            right1 = r1.right;
        }else {
            left1 = null;
            right1 = null;
        }
        if (r2 != null) {
            node.val += r2.val;
            left2 = r2.left;
            right2 = r2.right;
        }else {
            left2 = null;
            right2 = null;
        }
        // 左
        if (left1 != null || left2 != null) {
            node.left = new TreeNode(0);
            rcMerge(left1,left2,node.left);
        }
        // 右
        if (right1 != null || right2 != null) {
            node.right = new TreeNode(0);
            rcMerge(right1,right2,node.right);
        }
        return;
    }
}



