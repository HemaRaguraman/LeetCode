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
    public ListNode reverse(ListNode temp) {
        ListNode p = temp, q = null, r = null;
        while (p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        return q;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        
        for (int i = 1; i < left; i++) {
            temp = temp.next;
        }

        ListNode last = temp.next;
        ListNode curr = last.next;

        
        for (int i = 0; i < right - left; i++) {
            last.next = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            curr = last.next;
        }

        return dummy.next;
    }
}
