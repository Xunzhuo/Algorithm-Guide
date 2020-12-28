class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(root==null)

        {
            return result;

        }

        List<Integer> list = new LinkedList<Integer>();

        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.offer(root);

        TreeNode flag = root;

        int k=1;

        while(!deque.isEmpty())

        {
            TreeNode p =deque.poll();

            list.add(p.val);

            if(p.left!=null)

            {
                deque.offer(p.left);

            }

            if(p.right!=null)

            {
                deque.offer(p.right);

            }

            if(flag==p)

            {
                flag = deque.peekLast();

                if(k%2==0)

                {
                    Collections.reverse(list);

                }

                result.add(list);

                list = new LinkedList<Integer>();

                k++;

            }

        }

        return result;

    }

}