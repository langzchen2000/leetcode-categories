package LeetCode.Trees;
import TreesandGraphs.TreeNode;
import java.util.*;

import static TreesandGraphs.Solution_4_2.minimalTree;


public class Solution437 {
    //preprocess: calculate the prefix sum
    //prefix sum: the sum of the nodes from the root to a node (including)

    static int count;
    public static int pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);
        return count;
    }

    public static List<Long> helper(TreeNode root, int targetSum) {
        if (root == null) return new LinkedList<>();
        List<Long> leftSums = helper(root.left, targetSum);
        List<Long> rightSums = helper(root.right, targetSum);
        long value = root.val;
        for (int i = 0; i < leftSums.size(); i++) {
            long sum = leftSums.get(i) + value;
            leftSums.set(i, sum);
            if(sum == targetSum) count++;
        }
        for (int i = 0; i < rightSums.size(); i++) {
            long sum = rightSums.get(i) + value;
            rightSums.set(i, sum);
            if(sum == targetSum) count++;
            leftSums.add(sum);
        }
        leftSums.add(value);
        if (value == targetSum) count++;
        return leftSums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        TreeNode root = minimalTree(nums);

    }

}
