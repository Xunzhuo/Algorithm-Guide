class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length-1;

        int arr[] = new int[2];

        while(left<right)

        {
            if(nums[left]+nums[right]>target)

            {
                right--;

            }

            else if(nums[left]+nums[right]<target)

            {
                left++;

            }

            else{
                arr[0]=nums[left];

                arr[1]=nums[right];

                break;

            }

        }

        return arr;

    }

}