import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void findCombinations(int idx, int[] candidates, int target, List<List<Integer>> answer, List<Integer> res) {
        if(target == 0) {
            answer.add(new ArrayList<>(res));
            return;
        }
        for(int i=idx; i<candidates.length; i++) {
            if(i>idx && candidates[i-1]==candidates[i]) continue;
            if(candidates[i]>target) break;
            res.add(candidates[i]);
            findCombinations(i+1, candidates, target-candidates[i], answer, res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(0, candidates, target, combinations, new ArrayList<>());
        return combinations;
    }
}
// Topics -> Backtracking, Recursion, TC: O(2^n), SC: O(n), LC-40