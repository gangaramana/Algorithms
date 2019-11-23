package dynamic_programming.zero_one_knapsack;

class Zero1Knapsack {
    public static void main(String[] args) {
        Zero1Knapsack zero1Knapsack = new Zero1Knapsack();
        int value = zero1Knapsack.knapsack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7);
        System.out.println(value);
    }

    public int knapsack(int[] weight, int[] price, int maxWeight) {
        int[][] res = new int[weight.length + 1][maxWeight + 1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                int temp = 0;
                if (j >= weight[i - 1]) {
                    temp = price[i - 1] + res[i - 1][j - weight[i - 1]];
                } else {
                    temp = res[i][j - 1];
                }
                res[i][j] = Math.max(temp, res[i - 1][j]);
            }
        }
        int tp = weight.length, col = maxWeight;
        String result = "";
        while (tp > 0) {
            if (res[tp][col] == res[tp - 1][col]) {
                tp = tp - 1;
            } else if (res[tp][col] == res[tp][col - 1]) {
                col = col - 1;
            } else {
                result = result + " weight :" + weight[tp - 1]+" price :"+price[tp-1];

                col = col-weight[tp - 1];
                tp = tp - 1;
            }

        }
        System.out.println("result   "+result);
        return res[weight.length][maxWeight];
    }
}