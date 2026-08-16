class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s += " ";
        String answer = "";
        String word = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)!=' ') {
                word += s.charAt(i);
            } else if(!word.equals("")){
                answer = word + " " + answer;
                word = "";
            }
        }
        answer = answer.trim();
        return answer;
    }
}
// Topics - String Manipulation, Word Reversal, LC-151, O(n)