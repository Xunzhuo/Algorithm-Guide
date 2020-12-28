class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)

        {
            return true;

        }

        if(root.left==null&&root.right==null)

        {
            return true;

        }

        if(root.left==null||root.right==null)

        {
            return false;

        }

        return find(root.left,root.right);

    }

    public boolean find(TreeNode p,TreeNode q)

    {
        if(p==null&&q==null)

        {
            return true;

        }

        if(p==null||q==null)

        {
            return false;

        }

        if(p.val==q.val)

        {
            return find(p.left,q.right)&&find(p.right,q.left);

        }

        else

        {
            return false;

        }

    }

}