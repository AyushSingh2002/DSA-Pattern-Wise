import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Optimal Solution -> Using Monotonic stack
        int N = nums.length;
        int[] nge = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*N-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek()<=nums[i%N]) stack.pop();
            if(i<N) nge[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%N]);
        }
        return nge;
    }
}