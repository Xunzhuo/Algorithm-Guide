class Solution {
    public int[] exchange(int[] nums) {
        if(nums.length==0)

        {
            return nums;

        }

        int j = nums.length-1;

        for(int i=0;i<nums.length;i++)

        {
            if(i>=j)

            {
                break;

            }

            while(nums[j]%2==0)

            {
                if(i<j)

                {
                    j--;

                }

                else{
                    return nums;

                }

            }

            if(nums[i]%2==0)

            {
                int t =nums[i];

                nums[i] = nums[j];

                nums[j] = t;

            }

        }

        return nums;

    }

}