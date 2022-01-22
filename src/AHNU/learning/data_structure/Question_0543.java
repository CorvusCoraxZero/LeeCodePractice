package AHNU.learning.data_structure;

/*
   给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

    示例 :
    给定二叉树

              1
             / \
            2   3
           / \
          4   5
    返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。

    注意：两结点之间的路径长度是以它们之间边的数目表示。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question_0543 {

    public static void main(String[] args) {
        Question_0543 q = new Question_0543();
        // 4 1 6 0 2 5 7 ! ! ! 3 ! ! ! 8 #
        TreeNode node = TreeNode.getTreeLayer();
        System.out.println(q.diameterOfBinaryTree(node));
    }

    // 递归 从叶子节点往上找
    public int diameterOfBinaryTree(TreeNode root) {
        // 记录当前节点的最大边界值
        HashMap<TreeNode, Integer> map = new HashMap<>();
        rcSide(root,map);
        int max = 0;
        for (Integer value : map.values()) {
            if (max < value){
                max = value;
            }
        }
        return max;
    }

    public int rcSide(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int right = rcSide(root.right, map);
        int left = rcSide(root.left, map);
        map.put(root, right + left);
        return Math.max(right, left) + 1;
    }

}



