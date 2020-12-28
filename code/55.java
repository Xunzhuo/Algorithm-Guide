class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = helper(root);
        return list.get(list.size() - k);
    }

    public List<Integer> helper(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if(root == null)    return list;

        list.addAll(helper(root.left));
        list.add(root.val);
        list.addAll(helper(root.right));

        return list;
    }
}