class Solution {
    public int findPeakElement(int[] nums) {
        // Brute Force - Linear Iteration
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if((i==0 || nums[i-1]<nums[i]) && (i==n-1 || nums[i+1]<nums[i])) return i;
        }
        return Integer.MAX_VALUE;
    }
}
// Topics -> Array, Binary Search, LC-162