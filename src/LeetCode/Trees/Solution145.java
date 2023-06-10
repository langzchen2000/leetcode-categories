package LeetCode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import LeetCode.Util.TreeNode;
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode prev = null;
        while(!stack.isEmpty() || current != null){
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(current.right == null || prev == current.right){
                result.add(current.val);
                prev = current;
                current = null;
            } else{
                stack.push(current);
                current = current.right;
            }
        }
        return result;
    }
}
