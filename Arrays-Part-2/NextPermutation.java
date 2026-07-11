class Solution {
    public void reverse(int[] nums, int start, int end) {
        // Reverse array using 2 pointers
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        int start, end;
        // Find the break index of current arrangement
        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        // If idx is -1 the given permutation is the end - Reset to start!
        if(idx == -1) {
            start = 0;
            end = n-1;
            reverse(nums, start, end);
            return;
        }
        // Find the closest element to idx from subarray to the right and swap
        for(int i=n-1; i>idx; i--) {
            if(nums[i]>nums[idx]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        // Reverse the modified right subarry of idx - Since it's sorted decremetally!
        start = idx+1;
        end = n-1;
        reverse(nums, start, end);
    }
}
// Topics -> Arrays, Next Permutation, LC-31