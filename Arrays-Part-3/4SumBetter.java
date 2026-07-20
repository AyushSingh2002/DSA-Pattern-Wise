import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                Set<Integer> hashset = new HashSet<>();
                for(int k=j+1; k<n; k++) {
                    long sum = (long)nums[i]+nums[j]+nums[k];
                    long fourth = (long)(target-sum);
                    if(fourth>=Integer.MIN_VALUE &&
                       fourth<=Integer.MAX_VALUE && 
                       hashset.contains((int)fourth)) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)fourth);
                        temp.sort(Comparator.naturalOrder());
                        res.add(temp);
                    }
                    hashset.add(nums[k]);
                }
            }
        }
        List<List<Integer>> answer = new ArrayList<>(res);
        return answer;
    }
}
// Topics -> Array, Hashing, LC-18