class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Optimal Solution - Binary Search
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return (high+1+k);
    }
}
// Topics -> Array, Binary Search, LC-1539