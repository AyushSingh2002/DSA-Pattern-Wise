class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Brute Force Solution
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m+n];
        int i=0, j=0;
        int k=0;
        // Merge the two arrays into a single array
        while(i<m && j<n) {
            if(nums1[i]<=nums2[j]) {
                merged[k] = nums1[i++];
                k++;
            } else {
                merged[k] = nums2[j++];
                k++;
            }
        }
        // Runs if elements are left in nums1
        while(i<m) {
            merged[k] = nums1[i++];
            k++;
        }
        // Runs if elements are left in nums2
        while(j<n) {
            merged[k] = nums2[j++];
            k++;
        }
        // Find the median of the array
        if((m+n)%2==0) {
            double median = (double)(merged[(m+n)/2]+merged[((m+n)/2)-1])/2;
            return median;
        }
        return (double)merged[(m+n)/2];
    }
}
// Brute Force Solution
// Topic - Merging Sorted Arrays, Linear Algorithm