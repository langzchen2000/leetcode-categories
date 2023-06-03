package LinkedList;


import java.util.*;
public class Solution_2_6 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode node) {
        ListNode stepPointer = new ListNode(0, node);
        ListNode fastPointer = new ListNode(0, node);
        boolean isEven = false;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while(true) {
            stepPointer = stepPointer.next;
            stack.push(stepPointer.val);
            if(fastPointer.next != null) {
                fastPointer = fastPointer.next;
                if(fastPointer.next != null) {
                    fastPointer = fastPointer.next;
                } else {
                    break;
                }
            } else {
                isEven = true;
                break;
            }
        }
        if(!isEven){
            stack.pop();
            stepPointer = stepPointer.next;
        }
        while(stepPointer != null) {
            if(stack.pop() != stepPointer.val) return false;
            stepPointer = stepPointer.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = convertList(Arrays.asList(1, 2,3,3, 2, 1));
        displayLinkedlist(node);
        System.out.println();
        System.out.println(isPalindrome( node));
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
