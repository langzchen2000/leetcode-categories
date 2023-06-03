package LeetCode.Graphs;
import java.util.*;
class Solution2421 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }

        fa = new int[n];
        var id = new Integer[n];
        for (int i = 0; i < n; i++)
            fa[i] = id[i] = i;
        Arrays.sort(id, (i, j) -> vals[i] - vals[j]);//将id节点编号按节点值从小到大排列
        // size[x] 表示节点值等于 vals[x] 的节点个数，
        // 如果按照节点值从小到大合并，size[x] 也是连通块内的等于最大节点值的节点个数
        var size = new int[n];
        Arrays.fill(size, 1);
        //The program uses the fa array to keep track of the parent of each node in a disjoint-set data structure.
        // The find method recursively finds the parent of a node and performs path compression
        // to optimize future lookups.
        int ans = n; // 单个节点的好路径
        for (var x : id) {
            int vx = vals[x], fx = find(x);
            for (var y : g[x]) {
                y = find(y);
                if (y == fx || vals[y] > vx)
                    continue; // 只考虑最大节点值不超过 vx 的连通块
                if (vals[y] == vx) { // 可以构成好路径
                    ans += size[fx] * size[y]; // 乘法原理
                    size[fx] += size[y]; // 统计连通块内节点值等于 vx 的节点个数
                }
                fa[y] = fx; // 把小的节点值合并到大的节点值上
            }
        }
        return ans;
    }

    private int[] fa;

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
}

