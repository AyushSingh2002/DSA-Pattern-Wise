import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    // Method to find the largest rectangle in a histogram
    public int largestRectangleArea(int[] heights) {
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

    public int maximalRectangle(char[][] matrix) {
        // Optimal Solution
        int maxArea = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int heights[] = new int[m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}