class Solution {
    public int findPeakElement(int[] nums) {
        // Optimal Solution - Binary Search
        int n = nums.length;
        // Edge Cases
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int low = 1;
        int high = n-2;
        // Binary Search Logic
        while(low<=high) {
            int mid = (low+high)/2;
            // Check if mid is at the peak
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            // Check if mid is at the increasing slope
            else if(nums[mid]<nums[mid+1]) low = mid+1;
            // Check if mid is at ridge or decreasing slope
            // In case of ridge we can move in any direction
            else high = mid-1;
        }
        // Default return statement - Not executed
        return -1;
    }
}
// Topics -> Array, Binary Search, LC-162