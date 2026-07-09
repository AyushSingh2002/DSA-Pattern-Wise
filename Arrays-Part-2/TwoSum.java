import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            int req = target-nums[i];
            if(map.containsKey(req)) {
                result[0] = map.get(req);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}

// Topics -> Arrays, Hashing, LC-1