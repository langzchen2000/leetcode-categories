package LinkedList;

import java.util.Arrays;
import java.util.List;

public class Solution_2_5 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode sumList(ListNode num1, ListNode num2) {
        int carryout = 0;
        ListNode result = new ListNode();
        ListNode resultRoot = result;
       while(num1 != null || num2 != null) {
          int temp1 = num1 == null ? 0 : num1.val;
          int temp2 = num2 == null ? 0 : num2.val;
          int sum = temp1 + temp2 + carryout;
          carryout = sum/10;
          result.val = sum % 10;
          if((num1 != null && num1.next != null) && (num2 != null && num2.next != null) ) {
              result.next = new ListNode();
              result = result.next;
          }
          if(num1 != null) num1 = num1.next;
          if(num2 != null) num2 = num2.next;
       }
       if(carryout > 0) result.next = new ListNode(carryout);
       return resultRoot;

    }

    public static ListNode recursiveSumList(ListNode num1, ListNode num2, int carryout) {
        if(num1 == null && num2 == null) {
            if(carryout != 0) {
                return new ListNode(carryout);
            } else return null;
        }
        int temp1, temp2;
        if(num1 == null) {
            temp1 = 0;
        } else {
            temp1 = num1.val;
        }

        if(num2 == null) {
            temp2 = 0;
        } else {
            temp2 = num2.val;
        }

        ListNode result = new ListNode((temp1 + temp2 + carryout) % 10);
        result.next = recursiveSumList(num1 == null ? null : num1.next, num2 == null ? null: num2.next, (temp1 + temp2) / 10);
        return result;
    }

    public static void main(String[] args) {
        ListNode num1 = convertList(Arrays.asList(1,2,3));
        ListNode num2 = convertList(Arrays.asList(5,6,7));
        ListNode result = recursiveSumList(num1, num2, 0);
        displayLinkedlist(result);
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
