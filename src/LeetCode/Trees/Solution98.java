package LeetCode.Trees;

import LeetCode.Util.TreeNode;

public class Solution98 {
    /*Start from the definition of BST,
    * left subtree is less than the root
    * right subtree is larger than the root
    * the left subtree and right subtree are all BST
    * the minimum BST is null
    * so we use post order traversal to start from the leaf nodes
    * keep a max value, use in order traversal
    * we borrow a fact that in-order traversal traverses the tree in increasing order
     */

    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }
}
