package LeetCode.Trees;
import LeetCode.Util.TreeNode;

import java.util.*;
public class Solution1110 {
    /*convert the to_delete array to a hashset to enable O(1) lookup
    * if a node is deleted, its child nodes should be added to the result list
    * the parent node of the deleted node should be set to null
    * So use a post-order traversal because we should check the children before deleting them*/
    Set<Integer> hashSet;
    List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        hashSet = new HashSet<>();
        result = new ArrayList<>();
        for(int i : to_delete) {
            hashSet.add(i);
        }
        dfs(root);
        if(!hashSet.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);
        if(root.left != null && hashSet.contains(root.left.val)) {
            root.left = null;
        }
        if(root.right != null && hashSet.contains(root.right.val)) {
            root.right = null;
        }
        if(hashSet.contains(root.val)) {
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);
        }

    }

    public static void main(String[] args) {
        Solution1110 solution = new Solution1110();
    }
}
