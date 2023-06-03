package LeetCode.Trees;
import LeetCode.Util.TreeNode;
public class Solution236 {
    //assume a function lowestCommonAncestor returns the lowestCommonAncestor of p and q.
    //in a null tree, we shouldn't find any commonAncestor, so return null
    //if only one node is found (although it's impossible in the question context)
    //we should return the node
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }
    }
}
