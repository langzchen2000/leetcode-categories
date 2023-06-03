package LeetCode.Trees;


public class Solution1569 {
    //tree DP, result[node] = C^(leftnode_size)_(node_size - 1)*result[leftnode]*result[rightnode]
    //use insert to build a tree. the tree has a value as well as a size property
    //use post-order dfs to traverse the tree. using the DP to calculate the result[root]
    static final int MOD = 1000000007;
    long[][] c;
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        int size;
        int ans;

        TreeNode(int value) {
            this.value = value;
            this.size = 1;
            this.ans = 0;
        }
    }
    public int numOfWays(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        c = new long[n][n];
        c[0][0] = 1;
        for (int i = 1; i < n; ++i) {
            c[i][0] = 1;
            for (int j = 1; j < n; ++j) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }

        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            insert(root, val);
        }

        dfs(root);
        return (root.ans - 1 + MOD) % MOD;
    }

    public void insert(TreeNode root, int value) {
        TreeNode cur = root;
        while (true) {
            ++cur.size;
            if (value < cur.value) {
                if (cur.left == null) {
                    cur.left = new TreeNode(value);
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(value);
                    return;
                }
                cur = cur.right;
            }
        }
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        int lsize = node.left != null ? node.left.size : 0;
        int rsize = node.right != null ? node.right.size : 0;
        int lans = node.left != null ? node.left.ans : 1;
        int rans = node.right != null ? node.right.ans : 1;
        node.ans = (int) (c[lsize + rsize][lsize] % MOD * lans % MOD * rans % MOD);
    }
}


