class Solution {
    public int[] singleNumbers(int[] nums) {
        int result=0;

        for(int i=0;i<nums.length;i++)

        {
            result ^=nums[i];

        }

        int x = 1;

        while((result&x)==0)

        {
            x <<=1;

        }

        int arr[] = new int[2];

        for(int i=0;i<nums.length;i++)

        {
            if((nums[i]&x)==0)

            {
                arr[0]^=nums[i];

            }

            else

            {
                arr[1]^=nums[i];

            }

        }

        return arr;

    }

}