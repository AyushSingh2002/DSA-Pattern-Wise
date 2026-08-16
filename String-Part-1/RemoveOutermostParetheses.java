class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            if(cnt==0 && s.charAt(i)=='(') {
                cnt++;
            } else if(cnt==1 && s.charAt(i)==')') {
                cnt--;
            } else {
                if(s.charAt(i)=='(') {
                    cnt++;
                    answer += "(";
                } else {
                    cnt--;
                    answer += ")";
                }
            }
        }
        return answer;
    }
}
// Topics - String Manipulation, Parentheses, LC-1021, O(n)