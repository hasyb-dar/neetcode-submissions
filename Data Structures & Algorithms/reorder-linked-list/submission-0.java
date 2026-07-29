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
    ListNode findMiddle(ListNode A){
        ListNode slow = A, fast = A;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode l2 = mid.next;
        ListNode l1 = head;
        mid.next = null;

        ListNode prev = null;
        ListNode curr = l2;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        l2 = prev;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            ListNode n = l1.next;
            ListNode n1 = l2.next;
            tail.next = l1;
            tail = tail.next;
            tail.next = l2;
            tail = tail.next;
            /* l1 = l1.next;
            l2 = l2.next; */
            l1 = n;
            l2 = n1;
            
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
    }
}
