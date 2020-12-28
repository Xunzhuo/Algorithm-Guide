class Solution {
    public int[] spiralOrder(int[][] matrix) {


        int m = matrix.length;

        if(m==0)

        {
            int nums[] = new int[m];

            return nums;

        }

        int n = matrix[0].length;

        int nums[] = new int[m*n];

        if(matrix.length==0)

        {
            return nums;

        }



        int k =0,count=0;

        while(count<m*n)

        {
            for(int i=k;i<matrix[0].length-k;i++)

            {
                nums[count++]=matrix[k][i];

            }

            if(count==m*n) break;

            for(int i=k+1;i<matrix.length-k;i++)

            {
                nums[count++] = matrix[i][matrix[0].length-k-1];

            }

            if(count==m*n) break;

            for(int i=matrix[0].length-k-2;i>=k;i--)

            {
                nums[count++] = matrix[matrix.length-1-k][i];

            }

            if(count==m*n) break;

            for(int i=matrix.length-2-k;i>k;i--)

            {
                nums[count++] = matrix[i][k];

            }

            if(count==m*n) break;

            k++;

        }

        return nums;

    }

}