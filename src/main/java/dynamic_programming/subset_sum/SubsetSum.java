package dynamic_programming.subset_sum;

public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        boolean b = subsetSum.subSum(new int[]{2, 3, 7, 8, 10}, 7);
        System.out.println(b);

    }

    public boolean subSum(int[] a, int sum) {
        boolean[][] dp = new boolean[a.length + 1][sum + 1];
        for (int i = 0; i <= a.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {
//                if (j == 0) {
//                    dp[i][j] = true;
//                } else if (i >= a[i - 1]) {
                if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                } else if (j >= a[i - 1] && dp[i - 1][j - a[i - 1]] == true) {

                    dp[i][j] = true;
                }

            }

        }


        for (boolean[] b : dp) {
            for (boolean c : b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        int i = a.length, j = sum;
        String res = "";
        while (j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                res = res + " " + a[i - 1];
                j = j - a[i - 1];
            }


        }
        System.out.println("  res   "+res);


        return dp[a.length][sum];
    }
}
