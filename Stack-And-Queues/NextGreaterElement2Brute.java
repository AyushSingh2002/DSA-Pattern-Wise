class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Brute Solution
        int[] nge = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            nge[i] = -1;
            for(int j=i+1; j<i+nums.length; j++) {
                int idx = j%nums.length;
                if(nums[idx]>nums[i]) {
                    nge[i] = nums[idx];
                    break;
                }
            }
        }
        return nge;
    }
}