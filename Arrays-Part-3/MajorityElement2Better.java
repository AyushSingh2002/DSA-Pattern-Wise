import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Better Solution using Hashmap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        int majority = (int)Math.floor((nums.length)/3)+1;
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i])==majority) answer.add(nums[i]);
            if(answer.size() == 2) break;
        }
        return answer;
    }
}