package LeetCode.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode deserialize(String data) {
        String[] serialized = data.split(",");
        TreeNode root = new TreeNode();
        if(serialized[0].equals("n")) return null;
        else{
            root.val = Integer.parseInt(serialized[0]);
        }
        List<TreeNode> last = new ArrayList<>();
        last.add(root);
        int cur = 0;
        while(!last.isEmpty()) {
            List<TreeNode> newList = new ArrayList<>();
            for(TreeNode t : last) {
                cur += 1;
                t.left = serialized[cur].equals("n") ? null : new TreeNode(Integer.parseInt(serialized[cur]));
                if(t.left != null) newList.add(t.left);
                cur += 1;
                t.right = serialized[cur].equals("n") ? null : new TreeNode(Integer.parseInt(serialized[cur]));
                if(t.right != null) newList.add(t.right);
            }
            last = newList;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int)Math.pow(2,height)-1;
        String[][] matrix = new String[height][width];
        for(String[] r : matrix){
            Arrays.fill(r," ");
        }
        List<List<String>> list = new ArrayList<>();
        getBinary(matrix, root, 0, 0, width-1);
        for(String[] r : matrix){
            list.add(Arrays.asList(r));
        }
        for(List<String> ls : list){
            for(String s: ls) {
                System.out.print(s);
            }
            System.out.println();
        }
    }


    private static void getBinary(String[][] matrix, TreeNode root, int row, int left, int right){
        if(root == null) return;
        int mid = left + (right - left)/2;
        matrix[row][mid] = String.valueOf(root.val);
        getBinary(matrix, root.left, row+1, left, mid-1);
        getBinary(matrix, root.right, row+1, mid+1, right);
    }
    private static int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}