import java.util.ArrayList;
import java.util.List;

class Solution {
    public void findSubsets(int idx, int[] nums, List<List<Integer>> answer, List<Integer> res) {
        answer.add(new ArrayList<>(res));
        for(int i=idx; i<nums.length; i++) {
            res.add(nums[i]);
            findSubsets(i+1, nums, answer, res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        findSubsets(0, nums, answer, new ArrayList<>());
        return answer;
    }
}
// Topics -> Backtracking, Recursion, TC: O(2^n), SC: O(n), LC-78