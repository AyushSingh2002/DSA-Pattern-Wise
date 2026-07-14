class Solution {
    public void rotate(int[][] matrix) {
        // Brute Force Solution
        int n = matrix.length;
        int[][] answer = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                answer[j][n-1-i] = matrix[i][j];
            }
        }
        // Copy the elements back into the matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = answer[i][j];
            }
        }
    }
}
// Topics -> Arrays, Matrix, LC-48