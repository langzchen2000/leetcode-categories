package LinkedList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_2_2 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode returnKthToTheLast(ListNode node, int k) {
        ListNode temp = node;
        for(int i = 0; i < k; i++) {
            temp = temp.next;
        }
        while(temp.next != null) {
            temp = temp.next;
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = convertList(Arrays.asList(1,2,3,5,5,6,6,6,6));
        displayLinkedlist(node);
        node = returnKthToTheLast(node, 3);
        System.out.println();
        displayLinkedlist(node);
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
