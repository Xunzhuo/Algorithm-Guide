class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==0)

        {
            return 0;

        }

        int result = nums[0];

        int count=0;

        for(int i=0;i<nums.length;i++)

        {
            if(count==0&&i!=0)

            {
                result = nums[i];

            }

            if(nums[i]==result)

            {
                count++;

            }

            else

            {
                count--;

            }

        }

        return result;

    }

}