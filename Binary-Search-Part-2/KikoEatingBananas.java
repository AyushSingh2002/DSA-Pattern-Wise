import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Find the max element in the array
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int minSpeed = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = (low+high)/2;
            int hoursReq = 0;
            for(int banana : piles) {
                hoursReq += Math.ceil((double)banana/mid);
            }
            if(hoursReq <= h) {
                high = mid-1;
                minSpeed = mid;
            }
            else {
                low = mid+1;
            }
        }
        return minSpeed;
    }
}
// Topics -> Array, Binary Search, LC-875