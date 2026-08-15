class Solution {
    // Method to find the index of the maximum element in the matrix
    public int findMax(int[][] mat, int n, int m, int mid) {
        int maxEle = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=0; i<n; i++) {
            if(mat[i][mid]>maxEle) {
                maxEle = mat[i][mid];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    public int[] findPeakGrid(int[][] mat) {
        // Optimal Soltion - Binary Search
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        while(low<=high) {
            int mid = (low+high)/2;
            // Find the max element in the mid column
            int maxIdx = findMax(mat, n, m, mid);
            int max = mat[maxIdx][mid];
            int left = (mid-1>=0)?mat[maxIdx][mid-1]:-1;
            int right = (mid+1<m)?mat[maxIdx][mid+1]:-1;
            if(max>left && max>right) return new int[]{maxIdx, mid};
            else if(left>max) high = mid-1; 
            else low = mid+1;
        }
        return new int[]{-1,-1};
    }
}
// Topics - Binary Search, 2D Matrix Search, LC-852, O(n*log(m)))