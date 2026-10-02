import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        // Solution - Using Stack
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && k>0 && st.peek()-'0'>num.charAt(i)-'0') {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        // Handling the Edge Cases
        // 1. If stack did not remove anything - largest elements at the back
        while(k>0) {
            st.pop();
            k--;
        }
        // 2. If stack is empty after removing k digits
        if(st.isEmpty()) return "0";
        // 3. If there are 0s ahead of the number in the stack
        String res = "";
        while(!st.isEmpty()) {
            res = st.pop() + res;
        }
        res = res.replaceFirst("^0+", "");
        if(res.equals("")) return "0";
        return res;
    }
    
}