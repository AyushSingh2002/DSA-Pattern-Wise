import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Optimal Approach -> Single Pass
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(merged.isEmpty() || intervals[i][0] > merged.get(merged.size()-1)[1]) {
                merged.add(intervals[i]);
            } else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], intervals[i][1]);
            }
        }
        int[][] answer = new int[merged.size()][2];
        for(int i=0; i<merged.size(); i++) {
            answer[i] = merged.get(i);
        }
        return answer;
    }
}