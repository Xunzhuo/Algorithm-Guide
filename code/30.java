class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)  return new int[]{};

        queue.offer(root);

        while(!queue.isEmpty())

        {
            TreeNode p = queue.poll();

            list.add(p.val);

            if(p.left!=null)

            {
                queue.offer(p.left);

            }

            if(p.right!=null)

            {
                queue.offer(p.right);

            }

        }

        int[] res = new int[list.size()];

        for(int i=0; i<res.length; i++) {
            res[i] = list.get(i);

        }

        return res;

    }

}