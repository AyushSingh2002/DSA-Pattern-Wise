import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Optimal Solution -> Using Set
        int len = nums.length;
        if(len == 0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) set.add(num);
        // Start Iterating in the set
        for(int num : set) {
            // Check if the current element doesnot have any preceeding element -> Start point
            if(!set.contains(num-1)) {
                int cnt = 1;
                int x = num;
                // Count the number of consecutive elements in the set for the start point
                while(set.contains(x+1)) {
                    cnt++;
                    x++;
                }
                // Check if the current count is greater than longest
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}