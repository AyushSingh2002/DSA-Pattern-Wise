import java.util.Stack;

class Solution {
    private static final int MOD = 1_000_000_007;

    // Function to create next smaller element
    public int[] generateNSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }

    // Function to create previous smaller equal element
    public int[] generatePSEE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] psee = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            psee[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
    public int sumSubarrayMins(int[] arr) {
        // Optimal Solution - Using Stack
        int n = arr.length;
        int[] nse = generateNSE(arr, n);
        int[] psee = generatePSEE(arr, n);
        int sum = 0;
        for(int i=0; i<n; i++) {
            int left = i-psee[i];
            int right = nse[i]-i;
            sum = (int)(sum+(left*right*1L*arr[i])%MOD)%MOD;
        }
        return sum;
    }
}
// Topics -> Stack, TC: O(n), SC: O(n), LC-907