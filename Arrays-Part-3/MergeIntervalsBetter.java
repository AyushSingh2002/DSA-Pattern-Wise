import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Better Approach
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!merged.isEmpty() && end <= merged.get(merged.size()-1)[1]) continue;
            for(int j=i+1; j<n; j++) {
                if(intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            merged.add(new int[]{start, end});
        }
        int[][] answer = new int[merged.size()][2];
        for(int i=0; i<merged.size(); i++) {
            answer[i] = merged.get(i);
        }
        return answer;
    }
}