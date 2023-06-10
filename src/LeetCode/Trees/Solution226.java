package LeetCode.Trees;

import LeetCode.Util.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("1,2,3,n,n,4,5,n,n,n,n,");
        TreeNode.printTree(root);
        System.out.println();
        Solution226 solution = new Solution226();
        TreeNode revertedTree = solution.invertTree(root);
        TreeNode.printTree(revertedTree);
    }
}
