package AHNU.learning.data_structure;

/*
    给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

    提醒一下，二叉搜索树满足下列约束条件：

    节点的左子树仅包含键 小于 节点键的节点。
    节点的右子树仅包含键 大于 节点键的节点。
    左右子树也必须是二叉搜索树。

    示例 1：
        输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
    示例 2：
        输入：root = [0,null,1]
        输出：[1,null,1]
    示例 3：
        输入：root = [1,0,2]
        输出：[3,3,2]
    示例 4：
        输入：root = [3,2,4,1]
        输出：[7,9,4,10]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question_0538 {

    public static void main(String[] args) {
        Question_0538 q = new Question_0538();
        // 4 1 6 0 2 5 7 ! ! ! 3 ! ! ! 8 #
        TreeNode node = TreeNode.getTreeLayer();
        TreeNode bst = q.convertBST(node);
        //System.out.println(bst);
    }

    // 因为是二叉搜索树 所以元素位于越右的位置值越小
    // 使用一个队列 使节点按从小到大的顺序排列 之后遍历这个队列
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        listNode(root,queue);
        int count = 0;
        for (TreeNode treeNode : queue) {
            treeNode.val = count + treeNode.val;
            count = treeNode.val;
        }
        return root;
    }

    // 节点排序进入队列
    public void listNode(TreeNode root, List<TreeNode> queue){
        if (root == null) {
            return;
        }
        listNode(root.right,queue);
        queue.add(root);
        listNode(root.left,queue);
    }

}



