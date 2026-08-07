import java.util.Arrays;

class Solution {
    // Method to calculate the Division Result
    public int calculateDivisionRes(int[] arr, int mid) {
        int result = 0;
        for(int i=0; i<arr.length; i++) {
            result += Math.ceil((double)arr[i]/mid);
        }
        return result;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int answer = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            int divi = calculateDivisionRes(nums, mid);
            if(divi<=threshold) {
                answer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return answer;
    }
}
// Topics -> Array, Binary Search, LC-1283