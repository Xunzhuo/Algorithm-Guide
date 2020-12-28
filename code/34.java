class Solution {
    List<List<Integer>> result = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)

        {
            return result;

        }

        List<Integer> list = new LinkedList<Integer>();

        find(list,root,0,sum);

        return result;

    }

    public void find(List<Integer> list,TreeNode root,int target,int sum)

    {
        if(root==null)

        {
            return;

        }

        target+=root.val;

        list.add(root.val);

        if(target==sum&&root.left==null&&root.right==null)

        {
            result.add(new LinkedList<>(list));

        }

        else

        {
            find(list,root.left,target,sum);

            find(list,root.right,target,sum);

        }

        list.remove(list.size()-1);



    }

}