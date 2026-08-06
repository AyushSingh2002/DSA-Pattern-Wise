import java.util.Arrays;

class Solution {

    // Method to check if making the bouquets is possible on the given day
    public boolean isPossible(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int cnt = 0;
        int noOfBouquets = 0;
        for(int i=0; i<n; i++) {
            if(arr[i]<=day) {
                cnt++;
            } else {
                noOfBouquets += (cnt/k);
                cnt = 0;
            }
        }
        noOfBouquets += (cnt/k);
        if(noOfBouquets >= m) return true;
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // Optimal Solution using Binary Search
        // Edge Case - If number of required flowers are greater than available flowers
        int n = bloomDay.length;
        if(m*k>n) return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int minDays = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            boolean possible = isPossible(bloomDay, mid, m, k);
            if(possible) {
                minDays = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return minDays;
    }
}
// TC -> O(nlogn), SC -> O(1)
// Topics -> Array, Binary Search, LC-1482