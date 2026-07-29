/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/* class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev
            curr = next;               // move curr
        }

        return prev; // new head
    }
} */
/* class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // dummy is not part of logic, just returns new head safely
        dummy.next = prev;

        return dummy.next;
    }
} */

/* class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
} */




public class Solution {

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode current, ListNode prev) {

        // base case: end reached
        if (current == null) {
            return prev;
        }

        // store next node
        ListNode next = current.next;

        // reverse pointer
        current.next = prev;

        // move forward
        return reverse(next, current);
    }
}