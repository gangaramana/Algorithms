package dynamic_programming.two_subset_min_diff;


public class SubsetMinDiff {
    public static void main(String[] args) {
        SubsetMinDiff subsetMinDiff = new SubsetMinDiff();
        int res = subsetMinDiff.SMD(new int[]{1, 6, 5, 11});
        System.out.println(res);
    }

    public int SMD(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        boolean[][] dp = new boolean[A.length + 1][sum + 1];

        for (int i = 0; i <= A.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (A[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - A[i - 1]];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int minj = -1;

        for (int j = 0; j <= sum; j++) {
            if (dp[A.length][j]) {
                if (Math.abs(sum - 2 * j) < min) {
                    min = sum - 2 * j;
                    minj = j;

                }
            }
        }

        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(minj);
        return min;
    }
}
