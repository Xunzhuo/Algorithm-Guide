public class Codec {
    // Encodes a tree to a single string.
    //递归; 二叉树的遍历, 采用前序遍历, 1)要保留结构信息(除了左右孩子, 还要考虑null), 2)要设置间隔符, 从而区分不同的val
    public String serialize(TreeNode root) {
        //base case
        if(root==null)
            return "#!";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("!");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("!");
        return core(strs);
    }
    private int i;
    //二叉树的遍历, 前序遍历, 递归
    private TreeNode core(String[] strs){
        //base case
        if(i==strs.length)
            return null;
        if(strs[i].equals("#")){
            i++; //索引++
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[i]));
        i++;
        root.left = core(strs);
        root.right = core(strs);
        return root;
    }
}