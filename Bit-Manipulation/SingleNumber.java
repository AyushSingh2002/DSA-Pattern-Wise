class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int i=0; i<nums.length; i++) {
            single = single^nums[i];
        }
        return single;
    }
}
// Topics -> Bit Manipulation, TC: O(n), SC: O(1), LC-136