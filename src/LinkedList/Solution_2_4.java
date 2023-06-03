package LinkedList;

import java.util.Arrays;
import java.util.List;

public class Solution_2_4 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode partition(int x, ListNode node) {
        ListNode lessList = new ListNode(-1);
        ListNode tempLessList = lessList;
        ListNode largeList = new ListNode(-1);
        ListNode tempLargeList = largeList;
        while(node != null) {
            if(node.val >= x) {
                largeList.next = new ListNode(node.val);
                largeList = largeList.next;
            } else {
                lessList.next = new ListNode(node.val);
                lessList = lessList.next;
            }
            node = node.next;
        }
        lessList.next = tempLargeList.next;
        return tempLessList.next;
    }

    public static void main(String[] args) {
        ListNode node = convertList(Arrays.asList(1,6,6,6,6,2,3,5,5));
        displayLinkedlist(node);

        node = partition(4, node);
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
