package dynamic_programming.longest_common_subsequence;

public class RecurrsionMemoization {
    public static void main(String[] args) {
        RecurrsionMemoization recurrsionMemoization = new RecurrsionMemoization();
        recurrsionMemoization.memoization("stone".toCharArray(), "longest".toCharArray());
    }

    public String memoization(char[] a, char[] b) {
        a1 = a;
        b1 = b;
        int sum = helper(0,0);
        System.out.println(sum);
        return "";
    }

    char[] a1, b1;

    private int helper(int a, int b) {
        System.out.println("a    "+a +"   b ="+b);
        if (a>=a1.length || b >=b1.length) {
            return 0;
        } else if (a1[a] == b1[b]) {
            System.out.println("recursive  ");
            return 1 + helper(++a, ++b);
        } else {
            return Math.max(helper(++a, b), helper(a, ++b));
        }
    }
}
