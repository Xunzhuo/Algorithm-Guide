class Solution {
    public int maxDepth(TreeNode root) {
        return find(root,0);

    }

    public int find(TreeNode root,int num)

    {
        if(root==null)

        {
            return num;

        }

        return Math.max(find(root.left,num+1),find(root.right,num+1));

    }

}