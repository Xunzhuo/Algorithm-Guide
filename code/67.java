class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int i = 0,wang=0;

        while(nums[i]==0)

        {
            i++;

            wang++;

        }

        int cha=0;

        for(int j=i;j<4;j++)

        {
            cha+=nums[j+1]-nums[j]-1;

            if(nums[j]==nums[j+1]||cha>wang)

            {
                return false;

            }

        }

        return true;

    }

}