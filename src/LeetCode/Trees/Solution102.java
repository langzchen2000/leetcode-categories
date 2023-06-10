package LeetCode.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import LeetCode.Util.TreeNode;
//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
//102. 二叉树的层序遍历
//standard BFS, use a queue to store the nodes that visited but not processed
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodeQ = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) nodeQ.offer(root);
        int level = 1;
        while(!nodeQ.isEmpty()){
            Queue<TreeNode> temp = new ArrayDeque<>();
            while(!nodeQ.isEmpty()){
                TreeNode cur = nodeQ.poll();
                result.add(new ArrayList<Integer>());
                result.get(level-1).add(cur.val);
                if(cur.left != null) temp.offer(cur.left);
                if(cur.right != null) temp.offer(cur.right);
            }
            nodeQ = temp;
            level += 1;
        }
        return result;
    }
}
