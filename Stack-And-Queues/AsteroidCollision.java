import java.util.List;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        int n = asteroids.length;
        for(int i=0; i<n; i++) {
            if(asteroids[i]>0) stack.add(asteroids[i]);
            else {
                while(!stack.isEmpty() && stack.getLast()>0 && stack.getLast() < Math.abs(asteroids[i])) stack.remove(stack.size()-1);
                if(!stack.isEmpty() && stack.getLast()==Math.abs(asteroids[i])) stack.remove(stack.size()-1);
                else if(stack.isEmpty() || stack.getLast()<0) stack.add(asteroids[i]);
            }
        }
        int[] answer = stack.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
// Topics -> Stack, TC: O(n), SC: O(n), LC-735