package dynamic_programming.coin_change;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
       int result= coinChange.coinChange(new int[]{2,  5}, 11);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dpResult = new int[coins.length ][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] > j) {
                    dpResult[i][j] = dpResult[i ][j];
                } else {
                    if (i>0){
                    dpResult[i][j] = Math.min(dpResult[i - 1][j]==0?Integer.MAX_VALUE:dpResult[i - 1][j], 1+dpResult[i][j - coins[i - 1]]);}
                    else {
//                        dpResult[i][j]=Math.min()
                    }

                }
            }
        }
        return dpResult[coins.length][amount] == 0 ? -1 : dpResult[coins.length][amount];
    }
}
