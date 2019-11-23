package dynamic_programming.longest_common_subsequence;

public class LCSubsequence {
    public static void main(String[] args) {
        String a = "abcdaf", b = "racmanabbv";
        System.out.println(subSequence(a, b));

    }

    static String subSequence(String a, String b) {
        String res ="";
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        int[][] dpArray = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= first.length; i++) {
            for (int j = 0; j <= second.length; j++) {
                if (i == 0 || j == 0) {
                    dpArray[i][j] = 0;
                } else if (first[i - 1] == second[j - 1]) {
                    dpArray[i][j] = dpArray[i - 1][j - 1] + 1;
                } else {
                    dpArray[i][j] = Math.max(dpArray[i - 1][j], dpArray[i][j - 1]);
                }
            }
        }
        int k = first.length, l = second.length;
        while (k > 0 && l > 0) {
            if (dpArray[k][l] == dpArray[k][l - 1]) {
                l--;
            } else if (dpArray[k][l] == dpArray[k - 1][l]) {
                k--;
            } else {
                res=first[k-1]+res;
                k--;
                l--;
            }
        }
        return res;

    }
}
