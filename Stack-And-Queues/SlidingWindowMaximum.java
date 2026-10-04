import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Optimal Solution - Using Deque
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] answer = new int[n-k+1];
        int j=0;
        for(int i=0; i<n; i++) {
            while(!dq.isEmpty() && dq.getFirst()<=i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]) dq.removeLast();
            dq.addLast(i);
            if(i>=k-1) {
                answer[j] = nums[dq.getFirst()];
                j++;
            }
        }
        return answer;
    }
}
// Topics -> Deque, TC: O(n), SC: O(n), LC-239