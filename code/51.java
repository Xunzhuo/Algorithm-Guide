class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if(n<2){
            return 0;
        }
        return mergeSort(nums, 0, n-1);
    }

    private int mergeSort(int[] nums, int left, int right){
        if(left>=right){
            return 0;
        }
        int mid = left + ((right - left)>>1);
        int res = mergeSort(nums, left, mid);
        res += mergeSort(nums, mid+1, right);
        res += merge(nums, left, mid, right);
        return res;
    }

    private int merge(int[] nums, int left, int mid, int right){
        int[] arr = new int[right-left+1];
        int p=0, p1 = left, p2=mid+1;
        int res = 0;
        while(p1<=mid && p2<=right){
            if(nums[p1] > nums[p2]){
                arr[p++] = nums[p1++];
                res += right - p2 + 1;
            }else{
                arr[p++] = nums[p2++];
            }
        }
        while(p1<=mid){
            arr[p++] = nums[p1++];
        }
        while(p2<=right){
            arr[p++] = nums[p2++];
        }
        for(int i=0; i<arr.length; i++){
            nums[left+i] = arr[i];
        }
        return res;
    }
}