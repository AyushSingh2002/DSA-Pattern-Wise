class Solution {
    public double myPow(double x, int n) {
        // Optimal solution
        long N = n;
        if(N<0) {
            x = 1/x;
            N = -N;
        }
        double answer = 1;
        while(N>0) {
            if(N%2==1) answer *= x;
            x *= x;
            N /=2;
        }
        return answer;
    }
}
// Topics -> Recursion, Math, LC-50