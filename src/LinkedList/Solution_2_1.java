package LinkedList;
import java.util.*;
public class Solution_2_1 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeDups(ListNode node) {
        ListNode root = node;
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(node.val);
        while(node.next != null) {
            if(hashSet.contains(node.next.val)) {
                node.next = node.next.next;
            } else {
                hashSet.add(node.next.val);
                node = node.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode node = convertList(Arrays.asList(1,2,3,5,5,6,6,6,6));
        displayLinkedlist(node);
        removeDups(node);
        System.out.println();
        displayLinkedlist(node);
    }

    private static void displayLinkedlist(ListNode node) {
        if(node == null) return;
        while(node.next.next != null) {
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
        for(Integer i : list) {
            node.val = i;
            node.next = new ListNode();
            node = node.next;
        }
        return root;
    }
}
