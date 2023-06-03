package TreesandGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Solution_4_2 {

    public static TreeNode minimalTree(int[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int half = nums.length / 2;
        TreeNode root = new TreeNode(nums[half]);
        TreeNode left = minimalTree(Arrays.copyOfRange(nums,0,half));
        TreeNode right = minimalTree(Arrays.copyOfRange(nums,half+1, nums.length));
        root.left = left;
        root.right = right;
        return root;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        TreeNode root = minimalTree(nums);
        Utils.printTree(root);
    }
}
