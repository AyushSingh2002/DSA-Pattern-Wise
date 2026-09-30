class Solution {
    public long subArrayRanges(int[] nums) {
        // Brute Force
        int n = nums.length;
        long sum=0;
        for(int i=0; i<n; i++) {
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;
            for(int j=i; j<n; j++) {
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                sum += (largest-smallest);
            }
        }
        return sum;
    }
}
// Topics -> Stack, TC: O(n^2), SC: O(1), LC-2104