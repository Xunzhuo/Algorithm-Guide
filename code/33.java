class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0)

        {
            return true;

        }

        return find(postorder,0,postorder.length-1);

    }

    public boolean find(int[] postorder,int start,int end)

    {
        if(start>=end)

        {
            return true;

        }

        int i = start,j = end-1;

        while(i<end&&postorder[i]<postorder[end])

        {
            i++;

        }

        while(j>start&&postorder[j]>postorder[end])

        {
            j--;

        }

        if(i<j)

        {
            return false;

        }

        return find(postorder,start,i-1)&&find(postorder,j+1,end-1);

    }

}