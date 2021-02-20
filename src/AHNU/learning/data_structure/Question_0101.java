package AHNU.learning.data_structure;

/*
    给定一个二叉树，判断其是否是一个有效的二叉搜索树。

    假设一个二叉搜索树具有如下特征：

    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。

*/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Question_0101 {

    public static void main(String[] args) {
        Question_0101 q = new Question_0101();
        System.out.println(q.isSymmetric3(TreeNode.getTree()));
    }

    /**
     * 解题思路！！  根节点左右子树的中序遍历结果应该互为倒序
     * 出错 思路没有问题 但是该解法需要左右子树中值的数值不重复
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法二 层次遍历  写的一坨稀烂  因为需要处理为空的情况 导致很多错误
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);
        return isSymmetricRe(list);
    }

    public boolean isSymmetricRe(List<TreeNode> list) {
        for (int i = 0; i < list.size() / 2 - 1; i++) {
            try {
                if (list.get(i) == null && list.get(list.size() - 1 - i) == null || list.get(i).val != list.get(list.size() - 1 - i).val) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

        }
        ArrayList<TreeNode> x = new ArrayList<>();
        boolean isAllNull = true;
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) {
                x.add(treeNode.left);
                isAllNull = false;
            } else {
                x.add(null);
            }
            if (treeNode.right != null) {
                x.add(treeNode.right);
                isAllNull = false;
            } else {
                x.add(null);
            }
        }
        if (isAllNull) return true;
        return isSymmetricRe(x);
    }

    /**
     * 解法3： 递归解题 按照问题本来最自然的逻辑
     */

    public boolean isSymmetric3(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) {
            return false;
        }
        return l.val != r.val ? false : check(l.left, r.right) && check(l.right, r.left);
    }


}
