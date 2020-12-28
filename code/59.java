class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int i=0;i<32;i++)

        {
            int count = 0;

            for(int j =0;j<nums.length;j++)

            {
                if(((nums[j]>>i)&1)==1)

                {
                    count++;

                }

            }

            if(count%3!=0)

            {
                result = result |(1<<i);

            }

        }

        return result;

    }

}