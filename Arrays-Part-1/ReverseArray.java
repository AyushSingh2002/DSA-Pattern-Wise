class Solution {

    public int[] reverse(int[]nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        nums = reverse(nums, 0, (len-k-1));
        nums = reverse(nums, (len-k), len-1);
        nums = reverse(nums, 0, (len-1));
    }
}