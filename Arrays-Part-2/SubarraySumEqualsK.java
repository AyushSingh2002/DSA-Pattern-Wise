import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Optimal Solution -> Prefix Sum
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int prefixSum = 0;
        int cnt = 0;
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            int remove = prefixSum-k;
            cnt += map.getOrDefault(remove, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return cnt;
    }
}
// Topics -> Arrays, HashMap, LC-560