package dynamic_programming.rod_cutting;

public class RodCutting {
    public static void main(String[] args) {
        RodCutting rodCutting = new RodCutting();
        int k = rodCutting.cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30}, 10);
        System.out.println();
        System.out.println(k);

    }

    public int cutRod(int price[], int n) {
        int[] aux = new int[n + 1];
        int[] size = new int[n + 1];
        int temp;
        int max;
        for (int i = 1; i <= n; i++) {
            max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                temp = price[j] + aux[i - j - 1];
                if (temp > max) {
                    max = temp;
                    size[i] = j + 1;
                }

            }
            aux[i] = max;
        }
        for (int l : size) {
            System.out.print(l + " ");
        }
        System.out.println();

        for (int l : aux) {
            System.out.print(l + " ");
        }
        String s = "";
        n = 6;
        while (n > 0) {
            s = size[n] +","+ s;
            n = n - size[n];
        }
        System.out.println("the size of the is "+s);
        return aux[n];
    }

}
