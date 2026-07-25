class Solution {

    // Merge the divided arrays
    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int k=0; // For inserting & tracking elements in the temp array
        // Merge sorted halves
        while(left<=mid && right<=high) {
            if(arr[left]<=arr[right]) {
                temp[k] = arr[left];
                k++;
                left++;
            } else {
                temp[k] = arr[right];
                k++;
                right++;
            }
        }
        // If left subarray still has elements
        while(left<=mid) {
            temp[k] = arr[left];
            k++;
            left++;
        }
        // If right subarray still has elements
        while(right<=high) {
            temp[k] = arr[right];
            k++;
            right++;
        }
        // Copy back elements in the original array
        for(int i=0; i<temp.length; i++) {
            arr[low+i] = temp[i];
        }
    }

    // Count pair method
    public int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid+1;
        int count = 0;
        for(int i=low; i<=mid; i++) {
            while(right<=high && arr[i]>(long)2*arr[right]) right++;
            count += (right-(mid+1));
        }
        return count;
    }

    // Merge Sort Driver
    public int mergeSortCountPairs(int[] arr, int low, int high) {
        int countPairs = 0;
        if(low >= high) return countPairs;
        int mid = (low+high)/2;
        countPairs += mergeSortCountPairs(arr, low, mid);
        countPairs += mergeSortCountPairs(arr, mid+1, high);
        countPairs += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return countPairs;
    }

    public int reversePairs(int[] nums) {
        // Optimal Solution -> Using Merge Sort
        int n = nums.length;
        return mergeSortCountPairs(nums, 0, n-1);
    }
}
// Topics -> Array, Merge Sort, LC-493