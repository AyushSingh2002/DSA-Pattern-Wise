class Solution {
    public int countPrimes(int n) {
        // Using Seive Of Eratosthenes
        int[] isPrime = new int[n+1];
        for(int i=2; i*i<=n; i++) {
            if(isPrime[i] == 0) {
                for(int j = i*i; j<=n; j+=i) isPrime[j] = 1;
            }
        }
        int cnt = 0;
        for(int i=2; i<n; i++) {
            if(isPrime[i] == 0) cnt++;
        }
        return cnt;
    }
}
// Topics -> Math, TC: O(n log log n), SC: O(n), LC-204