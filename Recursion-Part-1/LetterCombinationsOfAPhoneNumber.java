import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void findCombinations(String digits, List<String> answer, int index, String current) {
        // Base Case
        if(index == digits.length()) {
            answer.add(current);
            return;
        }
        String s = map[digits.charAt(index)-'0'];
        for(int i=0; i<s.length(); i++) {
            findCombinations(digits, answer, index+1, current+s.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        findCombinations(digits, res, 0, "");
        return res;
    }
}
// Topics -> Backtracking, Recursion, TC: O(3^n), SC: O(n), LC-17