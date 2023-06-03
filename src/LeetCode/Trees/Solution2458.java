package LeetCode.Trees;
import TreesandGraphs.TreeNode;

import java.util.*;
import TreesandGraphs.Utils;
//do DFS twice
//height+depth of any node = the longest path height contains the node
//hard question may require preprocessing for later use
//In this question, the preprocessing is to store the node height in a hashmap
//one dfs calculates the height and another dfs calculates the depth
//The most tricky part is the calculation of the result[]
//after removing the left child of a node, the height of the root is equal to the longest path
//the longest path is either the path involving the right node or the path that doesn't involve the right node.
//when the right node is not involved, the logest path must not contain the node itself. so just compare
//result[node] and height[node.left]+depth[node.left]
import static TreesandGraphs.Solution_4_2.minimalTree;

public class Solution2458 {
    static Map<TreeNode, Integer> heightMap;
    static int[] result;
    static int[] response;
    public static int[] treeQueries(TreeNode root, int[] queries) {

        response = new int[queries.length];
        heightMap = new HashMap<>();
        heightMap.put(null, -1);
        dfs(root);
        result = new int[heightMap.size()];
        dfs2(root, -1, -1);
        for(int i = 0; i < queries.length; i++) {
            response[i] = result[queries[i]];
        }
        return response;
    }


    public static int dfs(TreeNode root) {
        if(root == null) return -1;//according to definition this should be -1
        int height = Math.max(dfs(root.left), dfs(root.right)) + 1;
        heightMap.put(root, height);
        return height;
    }

    public  static void dfs2(TreeNode node, int depth, int res) {
        if(node == null) return;
        depth++;
        result[node.val] = res;
        dfs2(node.left, depth, Math.max(res, heightMap.get(node.right) + depth + 1  ));
        dfs2(node.right, depth, Math.max(res,heightMap.get(node.left) + depth + 1 ));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = minimalTree(nums);
        treeQueries(root, new int[]{5});
    }
}
