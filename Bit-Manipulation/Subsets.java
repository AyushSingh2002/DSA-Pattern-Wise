import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subsets = 1<<nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0; i<subsets; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<nums.length; j++) {
                if((i & (1<<j))!=0) list.add(nums[j]);
            }
            answer.add(list);
        }
        return answer;
    }
}
// Topics -> Bit Manipulation, TC: O(n * 2^n), SC: O(1), LC-78