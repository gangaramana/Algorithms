package two_pointer;

public class ClosestSum {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 5, 7};
        int[] b = new int[]{10, 20, 30, 40};
        ClosestSum sum = new ClosestSum();
        sum.closestSumMethod(a,b,44);
    }

    public void closestSumMethod(int[] a, int[] b, int res) {
        int left = 0, right = b.length - 1, c = left, d = right;
        int diff = Integer.MAX_VALUE;
        while (left < a.length && right >= 0) {
            if (Math.abs(a[left] + b[right] - res) < diff) {
                diff = Math.abs(a[left] + b[right] - res);
                c = left;
                d = right;
            }
            if (a[left] + b[right] > res) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(a[c] + "   " + b[d]);
    }
}
