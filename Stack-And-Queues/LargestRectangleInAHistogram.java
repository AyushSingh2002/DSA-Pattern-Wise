import java.util.Stack;

class Solution {

    // Method to find next smaller element
    public int[] findNSE(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }

    // Method to find previous smaller element
    public int[] findPSE(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        // Brute Solution
        int n = heights.length;
        int[] nse = findNSE(heights, n);
        int[] pse = findPSE(heights, n);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) max = Math.max(max, heights[i]*(nse[i]-pse[i]-1));
        return max;
    }
}