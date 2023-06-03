package TreesandGraphs;

import java.util.Arrays;

import static TreesandGraphs.Solution_4_2.minimalTree;

public class Solution_4_5 {
    private static class Result {
        int max;
        int min;
        boolean isValid;

        boolean isNull;

        public Result(int max, int min, boolean isValid, boolean isNull) {
            this.max = max;
            this.min = min;
            this.isValid = isValid;
            this.isNull = isNull;
        }

        public Result() {
        }
    }

    public static Result validateBST(TreeNode root) {
        if(root == null) {
            return new Result(0, 0, true, true);
        }

        Result left = validateBST(root.left);
        Result right = validateBST(root.right);
        Result result = new Result();
        if(left.isValid && right.isValid) {
            if(left.isNull && right.isNull) {
                result.isValid = true;
                result.max = root.val;
                result.min = root.val;
                return result;
            }
            if(left.isNull) {
                if(root.val <= right.min) {
                    result.isValid = true;
                    result.min = root.val;
                    result.max = right.max;
                    return result;
                }
            }
            if(right.isNull) {
                if(root.val > left.max) {
                    result.isValid = true;
                    result.min = left.min;
                    result.max = root.val;
                    return result;
                }
            }
            if(root.val > left.max && root.val <= right.min) {
                result.isValid = true;
                result.min = left.min;
                result.max = right.max;
                return result;
            }
        }
        return result;
    }
    public static boolean simplerValidateBST(TreeNode node, int min, int max) {
        if(node == null) {
            return true;
        }
        if(node.val >= max || node.val < min) {
            return false;
        }
        return simplerValidateBST(node.left, min, node.val) && simplerValidateBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        TreeNode root = minimalTree(nums);
        root.right.val = 8;
        Utils.printTree(root);
        Result result = validateBST(root);
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean result1 = simplerValidateBST(root, min, max);
        System.out.println(result1);

    }
}
