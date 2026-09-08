import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void findSubsets(int idx, int[] nums, List<List<Integer>> answer, List<Integer> res) {
        answer.add(new ArrayList<>(res));
        for(int i=idx; i<nums.length; i++) {
            if(i>idx && nums[i-1]==nums[i]) continue;
            res.add(nums[i]);
            findSubsets(i+1, nums, answer, res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        findSubsets(0, nums, answer, new ArrayList<>());
        return answer;
    }
}
// Topics -> Backtracking, Recursion, TC: O(2^n), SC: O(n), LC-90