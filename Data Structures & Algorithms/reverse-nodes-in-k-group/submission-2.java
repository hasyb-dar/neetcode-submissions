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

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        int i = 1;

        ListNode start = head;

        // reverse first k nodes
        while (curr != null && i <= k) {

            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;

            i++;
        }

        // check whether next k nodes exist
        int j = 0;

        ListNode ss = curr;

        while (ss!= null && j <= k) {
            ss = ss.next;
            j++;
        }

        if (j >= k) {
            start.next = reverseKGroup(curr, k);
        } else {
            start.next = curr;
        }

        return prev;
    }
}
