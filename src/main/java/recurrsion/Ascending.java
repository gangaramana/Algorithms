package recurrsion;

public class Ascending {
    public static void main(String[] args) {
        Ascending ascending = new Ascending();
        ascending.order(new int[]{1, 2, 3, 4, 45}, 5);
    }

    public int order(int[] a, int l) {
        if (a.length == 1) {
            return 1;
        }
        return (a[l - 1] < a[l - 2]) ? 0 : order(a, l - 1);
    }
}
