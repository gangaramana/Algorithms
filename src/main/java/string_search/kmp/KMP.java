package string_search.kmp;

public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        kmp.prefixTable("ababaca".toCharArray(),7);
    }

    int[] f;

    public void prefixTable(char p[], int m) {
        int i = 1, j = 0;
        f = new int[m];
        f[0] = 0;
        while (i < m) {
            if (p[i] == p[j]) {
                f[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = f[j - 1];
            } else {
                f[i] = 0;
                i++;
            }

        }
        for (int k : f) {
            System.out.print(k+" ");
        }

    }
}
