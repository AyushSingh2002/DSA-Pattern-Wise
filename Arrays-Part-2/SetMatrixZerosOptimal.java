class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // Optimal Solution -> Using no extra space
        int col0 = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    // mark the i-th row
                    matrix[i][0] = 0;
                    // mark the j-th col
                    if(j!=0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        // Traverse the matrix excluding the hash arrays
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Transform the first row
        if(matrix[0][0] == 0) {
            for(int j=1; j<n; j++) {
                matrix[0][j] = 0;
            }
        }
        // Transform the first column
        if(col0 == 0) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
// Topics -> Arrays, Matrix, LC-73