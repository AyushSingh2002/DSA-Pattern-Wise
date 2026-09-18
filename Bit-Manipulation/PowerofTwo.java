class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1))==0;
    }
}
// Topics -> Bit Manipulation, TC: O(1), SC: O(1), LC-231