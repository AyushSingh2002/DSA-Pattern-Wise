class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int posIndex = 0; 
        int negIndex = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                result[negIndex] = nums[i];
                negIndex += 2;
            } else {
                result[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return result;
    }
}
// Topics -> Arrays, Two Pointers, LC-2149