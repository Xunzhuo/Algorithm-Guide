class Solution {
    int count = 0;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k > nums.length || nums.length == 0) return new int[0];
        int i = 0;
        int[] res = new int[nums.length - k + 1];
        while(i + k - 1 <= nums.length - 1){
            int max = nums[i];
            for(int j = i; j <= i + k - 1; j++){
                if(nums[j] > max) max = nums[j];
            }
            res[count] = max;
            i++; count++;
        }
        return res;
    }
}