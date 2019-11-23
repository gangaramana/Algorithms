package kadanes;

public class KadanesAlgo {
    public static void main(String[] args) {
        KadanesAlgo kadanesAlgo = new KadanesAlgo();
        kadanesAlgo.kadan(new int[]{1, -2, 0, 3});
    }

    public void kadan(int[] a) {
        int maxSoFar = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (maxSoFar < sum) {
                maxSoFar = sum;
            }
            if (sum < 0) {
                sum = 0;
            }

        }
        System.out.println(maxSoFar);
    }
}
