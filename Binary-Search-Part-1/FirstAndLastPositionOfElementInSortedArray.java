class Solution {
    // Method to find lower bound
    public int lowerBound(int[] arr, int target, int n) {
        int low = 0;
        int high = n-1;
        int answer = n;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]>=target) {
                answer = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return answer;
    }
    
    // Method to find upper bound
    public int upperBound(int[] arr, int target, int n) {
        int low = 0;
        int high = n-1;
        int answer = n;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]>target) {
                answer = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return answer;
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int lowerBound = lowerBound(nums, target, len);
        if(lowerBound == len || nums[lowerBound]!=target) return new int[]{-1,-1};
        return new int[]{lowerBound, upperBound(nums, target, len)-1};
    }
}
// Topics -> Array, Binary Search, LC-34