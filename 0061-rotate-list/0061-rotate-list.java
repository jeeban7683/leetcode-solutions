/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Reduce k
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Step 3: Initialize slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // Step 4: Move fast k steps ahead
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Step 5: Move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 6: Rotate the list
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}