class Solution {
    public int maxProduct(int[] nums) {
        // Brute Force - Compare the product of all subarrays
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            int product = nums[i];
            maxProduct = Math.max(maxProduct, product); // Compares all single elements
            for(int j=i+1; j<n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
}
// Topics -> Array, Brute Force, LC-152