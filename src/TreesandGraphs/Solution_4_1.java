package TreesandGraphs;
import java.util.*;
public class Solution_4_1 {
    private static class searchNode extends Node {
        boolean visited;
        public searchNode() {
            super();
            visited = false;
        }

        public searchNode(int _val) {
            super(_val);
            this.visited = false;
        }

        public searchNode(int _val, ArrayList<Node> _neighbors) {
            super(_val, _neighbors);
            this.visited = false;
        }
    }
    public static boolean routeBetweenNode(searchNode start, searchNode end) {
        Deque<searchNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(start);
        while(!nodeQueue.isEmpty()) {
            searchNode n = nodeQueue.remove();
            if(!n.visited) {
                if(n == end) return true;
                for(Node sn : n.neighbors) {
                    nodeQueue.add((searchNode)sn);
                }
            }
            n.visited = true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node n1 = new searchNode(1);
        Node n2 = new searchNode(2);
        Node n3 = new searchNode(3);
        n1.neighbors = Arrays.asList(n2);
        n2.neighbors = Arrays.asList(n3);
        n3.neighbors = Arrays.asList(n1);
        System.out.print(routeBetweenNode((searchNode)n1, (searchNode)n3));
    }
}
