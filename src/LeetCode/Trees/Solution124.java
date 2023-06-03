package LeetCode.Trees;

import LeetCode.Util.TreeNode;

public class Solution124 {
    /* we traverse each node to decide weither add its leftchild to the path or add its right child
    to the path. we only add both leftchild and rightchild when we consider the root node.
    we should start from the leaf node so we should use post-order traversal
    node values are between -1000 and 1000.
    dfs(root) returns the max path in the tree represented by root
    there are different situations:
        1. the max path contains the root node, and the root node doesn't have both
        left node and right node included in the path
        2. the root node only has one child included in the path
        3. the root is not contained in the path
    we use a global variable to record the max path with both left max and right max
    and dfs only returns the local max path, namely the path in a line without any branches
     */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if(node == null ) return -1001;
        int leftGain = dfs(node.left);
        int rightGain = dfs(node.right);

        int left = Math.max(leftGain,0);
        int right = Math.max(rightGain,0);
        max = Math.max(max, node.val + left + right);
        int gain = Math.max(node.val + left, node.val + right);

        return gain;
    }


}
