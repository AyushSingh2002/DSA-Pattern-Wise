import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Optimal Solution derived using Moore's Voting Alogrithm
        int cnt1=0, cnt2=0;
        int el1=Integer.MIN_VALUE, el2=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(cnt1==0 && nums[i]!=el2) {
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=el1) {
                cnt2=1;
                el2=nums[i];
            }
            else if(el1 == nums[i]) {
                cnt1++;
            }
            else if(el2 == nums[i]) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ls = new ArrayList<Integer>();
        cnt1=0; 
        cnt2=0;
        for(int i=0; i<nums.length; i++) {
            if(el1==nums[i]) cnt1++;
            if(el2==nums[i]) cnt2++;
        }
        int mini = (int)Math.floor(nums.length/3)+1;
        if(cnt1>=mini) ls.add(el1);
        if(cnt2>=mini) ls.add(el2);
        return ls;
    }
}