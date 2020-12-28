public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p,q;

        p = headA;

        q = headB;

        while(p!=null&&q!=null)

        {
            p = p.next;

            q = q.next;

        }

        ListNode a,b;

        a = headA;

        b = headB;

        while(p!=null)

        {
            p = p.next;

            a = a.next;

        }

        while(q!=null)

        {
            q = q.next;

            b = b.next;

        }

        while(a!=null&&b!=null)

        {
            if(a == b)

            {
                return a;

            }

            a = a.next;

            b = b.next;

        }

        return null;

    }

}