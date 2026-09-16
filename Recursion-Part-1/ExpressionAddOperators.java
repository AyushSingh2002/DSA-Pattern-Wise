import java.util.ArrayList;
import java.util.List;

class Solution {
    public void dfs(String num, int target, int start, long currentValue, long lastOperand, String expression, List<String> answer) {
        // Base Case
        if(start == num.length()) {
            if(currentValue == target) {
                answer.add(expression);
            }
            return;
        }
        // Recursion scenario
        for(int i=start; i<num.length(); i++) {
            // Skip Leading zeros and get current number
            if(i>start && num.charAt(start) == '0') return;
            String currentNum = num.substring(start, i+1);
            long currentNumValue = Long.parseLong(currentNum);
            // Rescursion Conditions
            if(start == 0) {
                dfs(num, target, i+1, currentNumValue, currentNumValue, currentNum, answer);
            } else {
                // Add current number with +
                dfs(num, target, i+1, currentValue+currentNumValue, currentNumValue, expression + "+" + currentNum, answer);
                // Add current number with -
                dfs(num, target, i+1, currentValue-currentNumValue, -currentNumValue, expression + "-" + currentNum, answer);
                // Add current number with *
                dfs(num, target, i+1, currentValue-lastOperand+lastOperand*currentNumValue, lastOperand*currentNumValue, expression + "*" + currentNum, answer);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> answer = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", answer);
        return answer;
    }
}
// Topics -> Backtracking, Recursion, TC: O(4^n), SC: O(n), LC-282