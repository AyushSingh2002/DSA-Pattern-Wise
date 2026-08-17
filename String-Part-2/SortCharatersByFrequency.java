import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> fMap = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            fMap.put(ch, fMap.getOrDefault(ch, 0)+1);
        }
        // Bucket Sort
        List<Character>[] buckets = new List[s.length()+1];
        for(char key: fMap.keySet()) {
            int freq = fMap.get(key);
            if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }
        // Build the sorted string
        StringBuilder sb = new StringBuilder();
        for(int pos=buckets.length-1; pos>=0; pos--) {
            if(buckets[pos]!=null) {
                for(char ch:buckets[pos]) {
                    for(int i=0; i<pos; i++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}
// Topics - String Manipulation, Frequency Sort, LC-451, O(n), Bucket Sort