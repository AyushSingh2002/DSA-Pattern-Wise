import java.util.HashMap;
import java.util.Map;

class Solution {
    public int beautySum(String s) {
        // Brute Force Solution
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            Map<Character, Integer> fMap = new HashMap<Character, Integer>();
            for(int j=i; j<s.length(); j++) {
                fMap.put(s.charAt(j), fMap.getOrDefault(s.charAt(j), 0)+1);
                int minF = Integer.MAX_VALUE;
                int maxF = Integer.MIN_VALUE;
                for(Integer f: fMap.values()) {
                    minF = Math.min(minF, f);
                    maxF = Math.max(maxF, f);
                }
                answer += (maxF-minF);
            }
        }
        return answer;
    }
}
// LC - 1781, Brute Force Solution, Time Complexity - O(n^3), Space Complexity - O(n)