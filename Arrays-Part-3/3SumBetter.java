import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Better Solution -> Using Set & Hashing
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            Set<Integer> hashset = new HashSet<Integer>();
            for(int j=i+1; j<nums.length; j++) {
                int third = -(nums[i]+nums[j]);
                if(hashset.contains(third)) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    temp.sort(Comparator.naturalOrder());
                    ans.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        List<List<Integer>> result = new ArrayList<>(ans);
        return result;
    }
}
// Topics -> Array, Hashing, LC-15