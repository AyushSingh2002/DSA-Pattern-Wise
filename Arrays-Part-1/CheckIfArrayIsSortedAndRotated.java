class Solution {
    public boolean check(int[] nums) {
        int count = 1;
        int len = nums.length;
        if(len==1)return true;
        for(int i=1;i<2*len;i++) {
            if(nums[(i-1)%len] <= nums[i%len]) count++;
            else count = 1;
            if(count==len) return true;
        }
        return false;
    }
}
// Topics -> Array, Sorting, Rotation, LC-1752