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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int i = 0;
        while(curr!=null){
            i++;
            curr = curr.next;
        }
        if (n >= i) {
            return head.next;
        }
        int j = 1;
        curr = head;
        while(curr.next!=null){
            if(j == i-n){
                curr.next = curr.next.next;
                break;
            }
            j++;
            curr = curr.next;
        }
        return head;

    }
}
