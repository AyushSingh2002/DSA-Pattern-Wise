class Solution {
    public int reversePairs(int[] nums) {
        // Brute Force
        int cnt = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                long temp = (long) 2*nums[j];
                if(nums[i] > temp) cnt++;
            }
        }
        return cnt;
    }
}
// Topics -> Array, Binary Search, LC-493
// This solution will not be accepted and gives a TLE (Time Limit Exceeded) error for large inputs.