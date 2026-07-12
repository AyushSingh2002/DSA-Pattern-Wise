import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Better Solution - O(nlogn)
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int currCnt = 1;
        int lastSmall = Integer.MIN_VALUE;
        int longest = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]-1 == lastSmall) {
                lastSmall = nums[i];
                currCnt++;
            } else if(nums[i] != lastSmall) {
                lastSmall = nums[i];
                currCnt=1;
            }
            longest = Math.max(longest, currCnt);
        }
        return longest;
    }
}
// Topics -> Arrays, Hashing, Sorting, LC-128