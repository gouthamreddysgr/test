import java.util.*;
class numwaysselectbuild {
    public long numberOfWays(String s) {
        long dp[][] = new long[4][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 0; i < s.length(); ++i) {
            for (int len = 1; len <= 3; ++len) {
                dp[len][s.charAt(i) - '0'] += dp[len - 1][1 - (s.charAt(i) - '0')]; // for this s[i], we can prepend subsequences of length `len-1` ending with a different character to it.
            }
        }
        return dp[3][0] + dp[3][1];
    }
    public static void main(String[] args) {
        numwaysselectbuild n = new numwaysselectbuild();
        long l = n.numberOfWays("001101");
        System.out.println(l);
    }
}