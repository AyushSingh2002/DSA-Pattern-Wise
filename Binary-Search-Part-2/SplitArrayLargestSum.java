class Solution {
    // Method to calculate the number of splits required given a particular subarray sum
    public int countSplitsForSum(int[] arr, int totalSum) {
        int splits = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(sum+arr[i]<=totalSum) {
                sum += arr[i];
            } else {
                splits++;
                sum = arr[i];
            }
        }
        return splits;
    }
    public int splitArray(int[] nums, int k) {
        // Optimized Solution - Using Binary Search
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0; i<nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while(low<=high) {
            int mid = (low+high)/2;
            int splitsReq = countSplitsForSum(nums, mid);
            if(splitsReq+1<=k) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
// Topics -> Binary Search, Array
// TC -> O(log(maxSum) * n)