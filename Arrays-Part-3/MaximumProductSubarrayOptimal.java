class Solution {
    public int maxProduct(int[] nums) {
        // Optimal Approach - Cumulative Product
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        // Left to right iteration
        int rightCumProduct = 1;
        for(int i=0; i<n; i++) {
            rightCumProduct *= nums[i];
            maxProduct = Math.max(maxProduct, rightCumProduct);
            if(rightCumProduct == 0) rightCumProduct = 1; 
        }
        // Right to Left iteration
        int leftCumProduct = 1;
        for(int i=n-1; i>=0; i--) {
            leftCumProduct *= nums[i];
            maxProduct = Math.max(maxProduct, leftCumProduct);
            if(leftCumProduct == 0) leftCumProduct = 1;
        }
        return maxProduct;
    }
}
// Topics -> Array, Kadane's Algorithm, LC-152