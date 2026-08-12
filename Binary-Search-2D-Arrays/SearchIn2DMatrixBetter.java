class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Better Solution - Linear Traversal with Binary Search
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            int low = 0;
            int high = matrix[i].length-1;
            while(low<=high) {
                int mid = (low+high)/2;
                if(matrix[i][mid]==target) return true;
                else if(matrix[i][mid]<target) low = mid+1;
                else high = mid-1;
            }
        }
        return false;
    }
}
// Topics - Binary Search, 2D Matrix Search, LC-74, O(m*log(n))