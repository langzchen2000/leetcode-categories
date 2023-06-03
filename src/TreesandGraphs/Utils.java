package TreesandGraphs;
import java.util.*;
public class Utils {
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

    public static TreeNode formTree(Integer[] data) {
        TreeNode root = new TreeNode(data[0]);
        form(root, 0, data);
        return root;
    }

    public static void form(TreeNode root, int rootIndex, Integer[] data) {
        int n = data.length;

        int leftIndex = 2 * rootIndex + 1;
        if (leftIndex < n && null != data[leftIndex]) {
            root.left = new TreeNode(data[leftIndex]);
            form(root.left, leftIndex, data);
        }

        int rightIndex = 2 * rootIndex + 2;
        if (rightIndex < n && null != data[rightIndex]) {
            root.right = new TreeNode(data[rightIndex]);
            form(root.right, rightIndex, data);
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
