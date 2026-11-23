import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1_000_000;
        
        // Precompute proper divisors for every possible substring length
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }
        
        // Step 1: Precompute minimum changes for every substring s[i..j]
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                for (int d : divisors[len]) {
                    cost[i][j] = Math.min(cost[i][j], getChanges(s, i, j, d));
                }
            }
        }
        
        // Step 2: DP to partition prefix s[0..i-1] into p semi-palindromes
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;
        
        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {
                for (int j = 2 * (p - 1); j <= i - 2; j++) {
                    if (dp[p - 1][j] != INF) {
                        dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + cost[j][i - 1]);
                    }
                }
            }
        }
        
        return dp[k][n];
    }
    
    // Counts mismatches to make s[start..end] a semi-palindrome with divisor d
    private int getChanges(String s, int start, int end, int d) {
        int changes = 0;
        int len = end - start + 1;
        
        for (int offset = 0; offset < d; offset++) {
            int left = start + offset;
            int right = start + len - d + offset;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    changes++;
                }
                left += d;
                right -= d;
            }
        }
        return changes;
    }
}
