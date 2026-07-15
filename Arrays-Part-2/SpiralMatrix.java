import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Only optimal solution for this problem
        List<Integer> answer = new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;
        while(top<=bottom && left<=right) {
            for(int i=left; i<=right; i++) {
                answer.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {
                for(int i=right; i>=left; i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for(int i=bottom; i>=top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }
        return answer;
    }
}
// Topics -> Arrays, Matrix, LC-54