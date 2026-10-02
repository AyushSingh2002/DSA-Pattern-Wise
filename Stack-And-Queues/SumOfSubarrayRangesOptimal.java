import java.util.Stack;

class Solution {

    // Method to find the next smallest element array
    public int[] findNSE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]) st.pop();
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }

    // Method to find the previous smallest equal element array
    public int[] findPSEE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] psee = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()]>nums[i]) st.pop();
            psee[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }

    // Method to find the next greater element array
    public int[] findNGE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]) st.pop();
            nge[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nge;
    }

    // Method to find the previous greater equal element
    public int[] findPGEE(int[] nums, int n) {
        Stack<Integer> st = new Stack<>();
        int[] pgee = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()]<nums[i]) st.pop();
            pgee[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pgee;
    }

    // Method to calculate the sum of Maximum Subarray
    public long sumOfMinimumSubarray(int[] nums, int n) {
        int[] nse = findNSE(nums, n);
        int[] psee = findPSEE(nums, n);
        long minSubarraySum = 0;
        for(int i=0; i<n; i++) {
            int left = i-psee[i];
            int right = nse[i]-i;
            minSubarraySum += (long)left*right*nums[i];
        }
        return minSubarraySum;
    }

    // Method to calculate the sum of Minimum Subarray
    public long sumOfMaximumSubarray(int[] nums, int n) {
        int[] nge = findNGE(nums, n);
        int[] pgee = findPGEE(nums, n);
        long maxSubarraySum = 0;
        for(int i=0; i<n; i++) {
            int left = i-pgee[i];
            int right = nge[i]-i;
            maxSubarraySum += (long)left*right*nums[i];
        }
        return maxSubarraySum;
    }

    public long subArrayRanges(int[] nums) {
        // Optimal Solution
        int n = nums.length;
        return sumOfMaximumSubarray(nums, n) - sumOfMinimumSubarray(nums, n);
    }
}
// Topics -> Stack, TC: O(n), SC: O(n), LC-2104