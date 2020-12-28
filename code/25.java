class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)

        {
            return root;

        }

        if(root.left==null&&root.right==null)

        {
            return root;

        }



        find(root);

        return root;

    }

    public void find(TreeNode p)

    {
        if(p==null)

        {
            return;

        }

        if(p.left==null&&p.right==null)

        {
            return;

        }

        TreeNode t = p.left;

        p.left = p.right;

        p.right = t;

        find(p.left);

        find(p.right);

    }

}