package TreesandGraphs;

import java.util.Arrays;

import static TreesandGraphs.Solution_4_2.minimalTree;

public class Solution_4_4 {
    //time complexity: O(nlog(n))
    //time mostly spent on array copying
    private static class Result {
        int height;
        boolean isBalanced;

        public Result(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        public Result() {
        }
    }
    public static Result checkBalanced(TreeNode node) {
        if(node == null) {
            return new Result(0, true);
        }
        if(node.left == null && node.right == null) {
            return new Result(1, true);
        }
        Result left = checkBalanced(node.left);
        Result right = checkBalanced(node.right);
        Result result = new Result();
        result.height = Math.max(left.height, right.height) + 1;
        result.isBalanced = (left.isBalanced && right.isBalanced) && (Math.abs(left.height - right.height) <= 1);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node2.left = node3;
        TreeNode root = minimalTree(nums);
        System.out.println(checkBalanced(root).isBalanced);
        System.out.println(checkBalanced(node1).isBalanced);
    }
}
