class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)

        {
            return 0;

        }

        int left = 0,right = nums.length-1;

        int mid = left +(right-left)/2;

        while(left<right)

        {
            mid = left+(right-left)/2;

            if(nums[mid]<target)

            {
                left = mid + 1;

            }

            else

            {
                right = mid;

            }

        }

        int a = left;

        left = 0;

        right = nums.length-1;

        while(left<right)

        {
            mid = (right-left)/2+left;

            if(nums[mid]<=target)

            {
                left = mid+1;

            }

            else{
                right = mid;

            }

        }

        if(nums[right]==target)

        {
            return right- a+1;

        }

        else

        {
            return right - a;

        }

    }

}