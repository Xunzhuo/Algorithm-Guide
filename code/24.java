class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null && B==null) return true;

        if(A==null)

        {
            return false;

        }

        if(B==null)

        {
            return false;

        }

        if(find(A,B))

        {
            return true;

        }

        if(isSubStructure(A.left,B))

        {
            return true;

        }

        if(isSubStructure(A.right,B))

        {
            return true;

        }

        return false;

    }

    public boolean find(TreeNode A,TreeNode B)

    {
        if(A==null&&B==null)

        {
            return true;

        }

        if(A==null)

        {
            return false;

        }

        if(B==null)

        {
            return true;

        }

        if(A.val==B.val)

        {
            return find(A.left,B.left)&&find(A.right,B.right);

        }

        else

        {
            return false;

        }

        // return true;

    }

}