class Solution {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);
        head.left=pre;//头结点的前驱是尾结点
        pre.right=head;//尾结点的后继是头结点
        return head;
    }
    public void dfs(Node root){
        if(root==null){
            return;
        }
        dfs(root.left);
        //当前结点不是头结点
        if(pre!=null){
            pre.right=root;//上一个结点的后继结点设为当前结点
        }
        else{
            head=root;//将当前节点设为头结点
        }
        root.left=pre;//当前结点的前驱结点
        pre=root;//将当前结点设为最后一个结点，即下一个结点的pre
        dfs(root.right);
        return;
    }
}