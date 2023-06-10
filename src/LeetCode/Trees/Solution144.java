package LeetCode.Trees;
import LeetCode.Util.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
// 144. 二叉树的前序遍历
//使用迭代法，使用栈来模拟递归
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null) {
            while(current != null){
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return result;
    }
}
