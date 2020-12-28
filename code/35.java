class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)

        {
            return head;

        }

        Node p = head;

        while(p!=null)

        {
            Node node = new Node(p.val);

            node.next = p.next;

            p.next = node;

            p = p.next.next;

        }

        p = head;

        while(p!=null&&p.next!=null)

        {
            if(p.random!=null)

            {
                p.next.random = p.random.next;

            }

            p = p.next.next;

        }

        Node x = head.next;

        Node q = head;

        while(q.next!=null)

        {
            Node t = q.next;

            q.next = q.next.next;

            q = t;

        }

        return x;

    }

}