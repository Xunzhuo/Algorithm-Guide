class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> list = new ArrayList<Integer>();

        Deque<TreeNode> deque = new LinkedList<>();

        if(root==null)  return result;

        TreeNode flag = root;

        deque.offer(root);

        while(!deque.isEmpty())

        {
            TreeNode p = deque.poll();

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

                result.add(list);

                list = new ArrayList<>();

            }

        }

        return result;

    }

}