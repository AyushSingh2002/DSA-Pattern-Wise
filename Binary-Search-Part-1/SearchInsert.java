class Solution {
    public int searchInsert(int[] nums, int target) {
        // Optimal Solution - Binary Search
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
// Topics -> Array, Binary Search, LC-35