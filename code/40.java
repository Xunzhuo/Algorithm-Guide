class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int nums[] = new int[k];

        if(k==0)

        {
            return nums;

        }

        for(int i=0;i<k&&i<arr.length;i++)

        {
            nums[i] = arr[i];

        }

        Arrays.sort(nums);

        for(int i=k;i<arr.length;i++)

        {
            if(arr[i]<nums[k-1])

            {
                nums[k-1] = arr[i];

                Arrays.sort(nums);

            }

        }

        return nums;

    }

}