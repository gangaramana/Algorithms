package dynamic_programming.rod_cutting;

public class RodCuttingWithCuttingCost {
    public static void main(String[] args) {
        RodCuttingWithCuttingCost rodCutting = new RodCuttingWithCuttingCost();
        int k = rodCutting.cutRodWithCost(new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30}, 10, 1);
        System.out.println();
        System.out.println(k);

    }

    public int cutRodWithCost(int price[], int n, int cost) {
        int[] aux = new int[n + 1];
        int[] size = new int[n + 1];
        int[] cuttingCost = new int[n + 1];
        int temp, tempCutCost;
        int max;
        for (int i = 1; i <= n; i++) {
            max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                tempCutCost = 0;
                temp = price[j] + aux[i - j - 1];
                if (i != j + 1) {
                    tempCutCost = (cuttingCost[j + 1] + cuttingCost[i - j - 1] + 1);
                    temp = temp - tempCutCost * cost;
                }
                if (temp > max) {
                    max = temp;
                    size[i] = j + 1;
                    cuttingCost[i] = tempCutCost;
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
        System.out.println("cutting cost");
        for (int k:cuttingCost){
            System.out.print(k+" ");
        }
        String s = "";
        n = 9;
        int em=n;
        while (n > 0) {
            s = size[n] + "," + s;
            n = n - size[n];
        }
        System.out.println("the size of the is " + s+" with cuts "+cuttingCost[em]);
        return aux[n];
    }
}
