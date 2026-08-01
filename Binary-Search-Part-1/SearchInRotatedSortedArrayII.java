class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (high+low)/2;
            if(nums[mid]==target) return true;
            if(nums[low]==nums[mid] && nums[high]==nums[mid]) {
                low++;
                high--;
                continue;
            }
            // Left Half is Sorted
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && nums[mid] >= target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            // Right Half is sorted
            else {
                if(nums[high] >= target && nums[mid] <= target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
// Topics -> Array, Binary Search, LC-81