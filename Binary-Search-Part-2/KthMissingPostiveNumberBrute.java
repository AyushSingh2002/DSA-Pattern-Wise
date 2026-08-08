class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Brute Force - Linear Traversal, Math
        for(int num:arr) {
            if(num <= k) k++;
            else break;
        }
        return k;
    }
}
// Topics -> Array, Binary Search, LC-1539