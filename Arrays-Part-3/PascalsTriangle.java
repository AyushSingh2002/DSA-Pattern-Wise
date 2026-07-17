import java.util.ArrayList;
import java.util.List;

class Solution {
    // Optimal Approach using Binomial Property of Coefficients
    public List<Integer> generateRow(int row) {
        int answer = 1;
        List<Integer> generatedRow = new ArrayList<Integer>();
        generatedRow.add(1);
        for(int col=1; col<row; col++) {
            answer *= (row-col);
            answer /= col;
            generatedRow.add(answer);
        }
        return generatedRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }
}
// Topics -> Arrays, Dynamic Programming, LC-118, Counting