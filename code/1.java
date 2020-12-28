class Solution {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {//保证交换过来的新元素位置也要正确，即令：a[i]=i
                if (nums[i] == nums[nums[i]]) {//将每个位置的数交换映射到其对应的数组下标下面，当出现新的元素与其对应的下标中的数字相等时，即为重复数字
                    return nums[i];
                }
                int temp = nums[i]; //交换，使对应下标的数组值与其下标值相等，即令 a[i]=i
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}