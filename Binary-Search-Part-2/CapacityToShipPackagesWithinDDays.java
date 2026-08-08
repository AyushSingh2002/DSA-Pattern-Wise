import java.util.Arrays;

class Solution {

    // Method to calculate the days for a given capacity
    public int findDays(int[] wt, int capacity) {
        int load = 0;
        int days = 1;
        for(int i=0; i<wt.length; i++) {
            if(load+wt[i]>capacity) {
                days++;
                load = wt[i];
            } else {
                load += wt[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        // Optimal Solution -> Binary Search
        // Answer range will be -> max(weights) to sum(weights)
        int low = Arrays.stream(weights).max().getAsInt();
        int high = 0;
        for(int weight:weights) high+=weight;
        int answer = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            int daysReq = findDays(weights, mid);
            if(daysReq<=days) {
                answer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return answer;
    }
}
// Topics -> Array, Binary Search, LC-1011