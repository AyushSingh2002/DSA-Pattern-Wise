class Solution {
    static final long MOD = 1_000_000_007;
    public long power(long x, long n) {
        long answer = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                answer = (answer * x) % MOD;
            }
            x = (x * x) % MOD;
            n /= 2;
        }
        return answer;
    }

    public int countGoodNumbers(long n) {
        long evenDigits = (n + 1) / 2;
        long oddDigits = n / 2;
        long evenAnswer = power(5, evenDigits);
        long oddAnswer = power(4, oddDigits);
        long answer = (evenAnswer * oddAnswer) % MOD;
        return (int) answer;
    }
}