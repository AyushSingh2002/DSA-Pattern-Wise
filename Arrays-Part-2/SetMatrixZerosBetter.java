class Solution {
    public void setZeroes(int[][] matrix) {
        // Better Solution -> Using row and column marker
        int m = matrix.length; // Row count
        int n = matrix[0].length; // Column count
        int[] markedRows = new int[m];
        int[] markedCols = new int[n];
        // Mark the rows and cols to be transformed
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    markedRows[i] = 1;
                    markedCols[j] = 1;
                }
            }
        }
        // Traverse to set the actual elements to 0
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(markedRows[i] == 1 || markedCols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// Topics -> Arrays, Matrix, LC-73