class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=1; i<=n; i++) xor1 = xor1^i;
        for(int i=0; i<n; i++) xor2 = xor2^nums[i];
        return xor1^xor2;
    }
}
// Topics -> Bit Manipulation, TC: O(n), SC: O(1), LC-268