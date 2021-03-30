package AHNU.learning.data_structure;

/*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

    示例 1：
        输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出：3
        解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
*/

public class Question_0236 {

    public static void main(String[] args) {
        Question_0236 q = new Question_0236();
        TreeNode tree = TreeNode.getTree();
        System.out.println(q.lowestCommonAncestor(tree,new TreeNode(1),new TreeNode(5)).val);
    }

    /*
    *  递归往下搜索
    * */

    private TreeNode answer;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return this.answer;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return false;
        boolean l = dfs(root.left,p,q);
        boolean r = dfs(root.right,p,q);
        if ((l && r ) || (root.val == p.val || root.val == q.val) && (l || r)){ // 这种情况 也就是左右节点都找了p或q的情况 或者p/q是q/p的父节点 的情况只会出现一次
            this.answer = root;
        }
        if (l || r || root.val == p.val || root.val == q.val){
            return true;
        }else {
            return false;
        }
    }
}