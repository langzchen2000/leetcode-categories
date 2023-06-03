package TreesandGraphs;

import java.util.Arrays;

import static TreesandGraphs.Solution_4_2.minimalTree;

public class Solution_4_8 {
    static TreeNode result;
    public static boolean firstCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return false;
        }
        boolean lson = firstCommonAncestor(node.left, p, q);
        boolean rson = firstCommonAncestor(node.right, p, q);

        if((lson && rson) || ((node == p || node == q) && (lson || rson))) {
            result = node;
        }
        return (node == p || node == q) || (lson || rson);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        TreeNode root = minimalTree(nums);
        TreeNode p = root.left.right;
        TreeNode q = root.left.left;
        Utils.printTree(root);
        firstCommonAncestor(root, p, q);
        System.out.println(result.val);
    }
}
