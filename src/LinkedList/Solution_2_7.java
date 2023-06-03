package LinkedList;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution_2_7 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean intersection(ListNode nodeA, ListNode nodeB) {
        if(nodeA == null || nodeB == null) return false;
        while(nodeA.next != null) {
            nodeA = nodeA.next;
        }

        while(nodeB.next != null) {
            nodeB = nodeB.next;
        }

        if(nodeA == nodeB) return true;
        else return false;
     }

    public static void main(String[] args) {
        ListNode nodeA = convertList(Arrays.asList(1 ));
        ListNode nodeB = convertList(Arrays.asList(1));
        ListNode nodeC = convertList(Arrays.asList(1,2));
        nodeA.next = nodeC;
        nodeB.next = nodeC;

        System.out.println(intersection(nodeA,nodeB));
        System.out.println();
    }

    private static void displayLinkedlist(ListNode node) {
        if(node == null) return;
        while(node.next != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
        System.out.print(node.val);
        return;
    }

    private static ListNode convertList(List<Integer> list) {
        ListNode node = new ListNode();
        ListNode root = node;
        for(int i = 0; i < list.size() - 1; i++) {
            node.val = list.get(i);
            node.next = new ListNode();
            node = node.next;
        }
        node.val = list.get(list.size() - 1);
        return root;
    }
}
