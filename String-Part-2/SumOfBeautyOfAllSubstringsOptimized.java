class Solution {
    public int beautySum(String s) {
        // Optimized Solution
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            int[] fMap = new int[26];
            int maxF = Integer.MIN_VALUE;
            for(int j=i; j<s.length(); j++) {
                fMap[s.charAt(j) - 'a']++;
                maxF = Math.max(maxF, fMap[s.charAt(j)-'a']);
                int minF = Integer.MAX_VALUE;
                for(int f: fMap) {
                    if(f>0) minF = Math.min(minF, f);
                }
                answer += (maxF-minF);
            }
        }
        return answer;
    }
}
// LC - 1781, Optimized Solution, Time Complexity - O(n^2.26), Space Complexity - O(n), Reduced operations by using array instead of HashMap and keeping track of max frequency while iterating through the string.