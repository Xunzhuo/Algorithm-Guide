class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;

    }

    public int helper(TreeNode root)

    {
        if(root == null) return 0;

        int left = helper(root.left);

        if(left == -1) return -1; //左子树不平衡直接返回-1

        int right = helper(root.right);

        if(right == -1) return -1; //右子树不平衡直接返回-1

        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);

    }

}