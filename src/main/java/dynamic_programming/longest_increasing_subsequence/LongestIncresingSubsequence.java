package dynamic_programming.longest_increasing_subsequence;

public class LongestIncresingSubsequence {
    public static void main(String[] args) {
        LongestIncresingSubsequence longestIncresingSubsequence = new LongestIncresingSubsequence();
        int x = longestIncresingSubsequence.Lis(new int[]{10, 22, 9, 33, 21, 50, 41, 60});
        System.out.println(x);
    }

    public int Lis(int[] a) {
        if (a.length <= 1) {
            return a.length;
        }
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp[a.length - 1];
    }
}
