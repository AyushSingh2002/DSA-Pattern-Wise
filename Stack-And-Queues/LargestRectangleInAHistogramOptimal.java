import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int largestRectangleArea(int[] heights) {
        // Optimal Solution
        Deque<Integer> st = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()]>heights[i]) {
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(maxArea, (heights[element]*(nse-pse-1)));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int element = st.peek();
            st.pop();
            int nse = n;
            int pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
}