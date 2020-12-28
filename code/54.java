class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length==0)

        {
            return 0;

        }

        if(nums.length==1&&nums[0]!=0)

        {
            return 0;

        }

        if(nums[nums.length-1]==nums.length-1)

        {
            return nums.length;

        }

        int left = 0,right=nums.length-1;

        int mid = 0;

        while(left<right)

        {
            mid = left+(right-left)/2;

            if(nums[mid]==mid)

            {
                left = mid+1;

            }

            else

            {
                right = mid;

            }

        }

        return right;

    }

}