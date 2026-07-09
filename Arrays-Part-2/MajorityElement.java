class Solution {
    public int majorityElement(int[] nums) {
        // Optimal Solution -> Moore's Voting Algo
        int cnt=0;
        int el=-1;
        for(int i=0; i<nums.length; i++) {
            if(cnt==0) {
                el = nums[i];
                cnt=1;
            }
            else if(el == nums[i]) {
                cnt++;
            }
            else {
                cnt--;
            }
        }
        return el;
    }
}