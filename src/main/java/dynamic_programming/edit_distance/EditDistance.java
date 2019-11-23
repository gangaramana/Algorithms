package dynamic_programming.edit_distance;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        int res = editDistance.distance("abcdef", "azced");
        System.out.println(res);

    }

    public int distance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = i;
                    continue;
                }
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));

                }
            }
        }
        int j = dp.length;
        for (int k = dp[0].length; k > 0; k++) {

        }

        return dp[s1.length()][s2.length()];
    }
}
