class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Edge Cases
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int low = 1;
        int high = n-2;
        while(low<=high) {
            int mid = (low+high)/2;
            // Check if the current mid element is the answer 
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            // Elimination Logic for left half
            if(((mid%2==0)&&(nums[mid]==nums[mid+1])) || ((mid%2==1)&&(nums[mid]==nums[mid-1]))) {
                low = mid+1;
            }
            // Elimination Logic for right half
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}
// Topics -> Array, Binary Search, LC-540