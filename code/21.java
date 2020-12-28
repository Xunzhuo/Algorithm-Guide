/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null)

        {
            return head;

        }

        ListNode p=head;

        while(k!=1)

        {
            if(p.next==null)

            {
                return head;

            }

            p = p.next;

            k--;

        }

        ListNode q = head;

        while(p.next!=null)

        {
            p = p.next;

            q = q.next;

        }

        return q;

    }

}