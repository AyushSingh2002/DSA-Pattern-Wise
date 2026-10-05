class Solution {

    // Method to calculate the right max
    public int[] findRightMax(int[] height, int n) {
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) rightMax[i] = Math.max(rightMax[i+1], height[i]);
        return rightMax;
    }

    // Method to calculate the left max
    public int[] findLeftMax(int[] height, int n) {
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) leftMax[i] = Math.max(leftMax[i-1], height[i]);
        return leftMax;
    }

    public int trap(int[] height) {
        // Optimal Solution
        int n = height.length;
        int[] leftMax = findLeftMax(height, n);
        int[] rightMax = findRightMax(height, n);
        int sum = 0;
        for(int i=0; i<n; i++) sum += Math.min(leftMax[i], rightMax[i])-height[i];
        return sum;
    }
}
// Topics -> Array, Two Pointers, TC: O(n), SC: O(n)