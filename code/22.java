class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)

        {
            return head;

        }

        ListNode p = head,q=null;

        while(p!=null)

        {
            ListNode next = p.next;

            p.next = q;

            q = p;

            p = next;

        }

        return q;

    }

}