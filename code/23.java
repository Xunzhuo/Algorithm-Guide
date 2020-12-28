class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)

        {
            return l2;

        }

        if(l2==null)

        {
            return l1;

        }

        ListNode head = new ListNode(0);

        ListNode result = head;

        while(l1!=null&&l2!=null)

        {
            if(l1.val<=l2.val)

            {
                result.val = l1.val;

                l1 = l1.next;

            }

            else

            {
                result.val = l2.val;

                l2 = l2.next;

            }

            ListNode p = new ListNode(0);

            result.next = p;

            result = p;

        }

        if(l1!=null)

        {
            result.val = l1.val;

            result.next = l1.next;

        }

        if(l2!=null)

        {
            result.val = l2.val;

            result.next = l2.next;

        }

        return head;

    }

}