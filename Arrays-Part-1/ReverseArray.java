class Solution {

    // Function to reverse any given array based on the start and end index
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


// Topics -> Arrays, 2 pointers, reversal, observation, LC-189