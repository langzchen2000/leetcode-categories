package LeetCode.LinkedList;

import LeetCode.Util.ListNode;
//recursive: function returns the next node, base case: both nodes are null
//At each node: take null nodes as 0, carry sums the two nodes
//follow the principle of summation
//carry out is carry/10, val is carry % 10
//Time: O(L1 + L2) Space: O(1)
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        if (l1 != null) {
            carry += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carry += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(carry % 10);
        node.next = add(l1, l2, carry / 10);
        return node;
    }
}


