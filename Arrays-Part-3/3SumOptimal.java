import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Optimal Solution -> 2 pointers
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0) {
                    j++;
                }
                else if(sum > 0) {
                    k--;
                }
                else {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    answer.add(temp);
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return answer;
    }
}
// Topics -> Array, Sorting, Two Pointers, LC-15