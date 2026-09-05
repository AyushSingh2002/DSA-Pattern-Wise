import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        findAnswer(res, "", 0, 0, n);
        return res;
    }
    
    public void findAnswer(List<String> answer, String s, int left, int right, int n) {
        if(s.length() == 2*n) {
            answer.add(s);
            return;
        }
        if(left<n) findAnswer(answer, s+"(", left+1, right, n);
        if(right<left) findAnswer(answer, s+")", left, right+1, n);
    }
}
// Topics -> Recursion, Backtracking, LC-22