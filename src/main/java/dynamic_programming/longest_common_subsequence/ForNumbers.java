package dynamic_programming.longest_common_subsequence;

public class ForNumbers {
    public static void main(String[] args) {
        ForNumbers forNumbers = new ForNumbers();
        System.out.println(forNumbers.Subsequence("10010101", "010110110"));

    }


    public String Subsequence(String a1, String b1) {
        String res = "";
        int[][] arr = new int[a1.length() + 1][b1.length() + 1];
        char[] a = a1.toCharArray();
        char[] b = b1.toCharArray();
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        System.out.println(arr[a.length][b.length] +"       "+a.length   +"    "+b.length);
        int k = a.length, l = b.length;
        for (int i=0;i<=a1.length();i++){
            for (int j=0;j<b1.length();j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        while (k > 0 && l > 0) {
            if (arr[k][l] == arr[k][l - 1]) {
                l--;

            } else if (arr[k][l] == arr[k - 1][l]) {
                k--;
            } else {
                res = a[k - 1] + res;
                k--;
                l--;

            }

        }

        return res;
    }
}
