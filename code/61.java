class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        int left = 1,right = 2;

        int sum = 3;

        while(right<target)

        {
            if(sum<target)

            {
                right++;

                sum+=right;

            }

            else if(sum>target)

            {
                sum-=left;

                left++;

            }

            else{
                int nums[] = new int[right-left+1];

                for(int i=0;i<=right-left;i++)

                {
                    nums[i] = left+i;

                }

                list.add(nums);

                right++;

                sum+=right;

            }

        }

        return  list.toArray(new int[0][]);

    }

}