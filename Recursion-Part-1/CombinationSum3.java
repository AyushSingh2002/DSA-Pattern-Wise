import java.util.ArrayList;
import java.util.List;

class Solution {
    public void findCombinations(int k, int sum, int last, List<List<Integer>> answer, List<Integer> res) {
        if(sum == 0 && res.size() == k) {
            answer.add(new ArrayList<>(res));
            return;
        }
        if(sum <= 0 && res.size() > k) return;
        for(int i=last; i<=9; i++) {
            if(i<=sum) {
                res.add(i);
                findCombinations(k, sum-i, i+1, answer, res);
                res.remove(res.size()-1);
            } else {
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        findCombinations(k, n, 1, answer, new ArrayList<>());
        return answer;
    }
}
// Topics -> Backtracking, Recursion, TC: O(2^n), SC: O(n), LC-216