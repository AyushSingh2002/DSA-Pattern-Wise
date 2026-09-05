import java.util.ArrayList;
import java.util.List;

class Solution {
    public void findCombinations(int idx, int[] candidates, int target, List<List<Integer>> answer, List<Integer> list) {
        if(idx == candidates.length) {
            if(target == 0) {
                answer.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[idx] <= target) {
            list.add(candidates[idx]);
            findCombinations(idx, candidates, target-candidates[idx], answer, list);
            list.remove(list.size()-1);
        }
        findCombinations(idx+1, candidates, target, answer, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        findCombinations(0, candidates, target, answer, new ArrayList<>());
        return answer;
    }
}
// Topics -> Backtracking, Recursion, TC: O(2^n), SC: O(n), LC-39