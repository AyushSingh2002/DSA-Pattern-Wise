class Solution {
    public static final int MOD = 1_000_000_007;
    public int count(long index, long n) {
        // Base Case
        if(index==n) return 1;
        int result = 0;
        // Index is even
        if(index%2==0) {
            int[] evenDigits = {0,2,4,6,8};
            for(int digit:evenDigits) {
                result = (result+count(index+1,n))%MOD;
            }
        }
        // Index is odd
        else {
            int[] primeDigits = {2,3,5,7};
            for(int prime:primeDigits) {
                result = (result+count(index+1,n))%MOD;
            }
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        int answer = count(0,n);
        return answer;
    }
}
// Topics -> Recursion, Backtracking, LC-1922 (Solutions Doesnt work but good for understanding)