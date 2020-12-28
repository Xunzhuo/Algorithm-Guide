class Solution {
    public int minArray(int[] nums) {
        if(nums.length==0)

        {
            return 0;

        }

        int left=0,right=nums.length-1;

        int mid=0;

        while(left<right)

        {
            mid = left+(right-left)/2;

            if(nums[mid]<nums[right])

            {
                right = mid;

            }

            else  if(nums[mid]>nums[right])

            {
                left = mid+1;

            }

            else{
                right--;

            }

        }

        return nums[right];

    }

}