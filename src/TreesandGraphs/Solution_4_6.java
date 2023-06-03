package TreesandGraphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_4_6 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    public static Node successor(Node node) {
            if(node == null) return null;
            if(node.right == null) {
                Node pre = node;
                Node current = node.parent;
                while(current != null && current.left != pre) {
                    pre = current;
                    current = current.parent;
                }
                return current;
            } else {
                return theLeftMost(node.right);
            }

    }

    private static Node theLeftMost(Node right) {
        if(right == null) return null;
        while(right.left != null) {
            right = right.left;
        }
        return right;
    }


    public static void main(String[] args) {
        Map<Node,Integer> nodeMap = new HashMap<>();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        nodeMap.put(node1, 1);
        nodeMap.put(node2, 2);
        nodeMap.put(node3, 3);
        nodeMap.put(node4, 4);
        nodeMap.put(node5, 5);
        nodeMap.put(node6, 6);
        nodeMap.put(node7, 7);
        nodeMap.put(node8, 8);
        nodeMap.put(null, null);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        node5.left = node7;
        node5.right = node8;
        node7.parent = node5;
        node8.parent = node5;
        node3.right = node6;
        node6.parent = node3;
        System.out.println(nodeMap.get(successor(node7)));
        System.out.println(nodeMap.get(successor(node8)));
        System.out.println(nodeMap.get(successor(node2)));
    }
}
